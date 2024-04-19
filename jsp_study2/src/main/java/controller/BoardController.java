package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.MemberVo;
import service.BoardService;
import service.BoardServiceImpl;




/**
 * Servlet implementation class BoardController
 */
@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	private RequestDispatcher rdp;
	private String destPage;
	private int isOk;
	private BoardService bsv;
       
 
    public BoardController() {
       bsv = new BoardServiceImpl();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("잘 들어오는지 테스트..");
		//메서드 실행
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
		log.info(path);
		
		switch (path) {
		case "register":
			log.info("register 들어왔습니다.");
			destPage = "/board/register.jsp";
			break;
		case "insert" :
			try {
				//jsp 화면에서 보내온 파라미터 저장
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				
				BoardVO bvo = new BoardVO(title, writer, content);
				log.info("insert 객체 >>>{}", bvo);
				isOk = bsv.register(bvo);
				log.info("insert"+((isOk>0)? "성공":"실패")+ isOk);
				
				destPage = "/index.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "list":
			try {
				//list 버튼을 클릭하면 전체 list를 뿌리기
				List<BoardVO> list = bsv.getList();
				log.info("list >>> {}",list);
				request.setAttribute("list", list);
				destPage = "/board/list.jsp";
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			//detail 상세보기
			//modify 게시물수정
		case "detail": case "modify":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = bsv.getDetail(bno);
				log.info("detail bvo >>>{}",bvo);
				request.setAttribute("bvo", bvo);
				destPage = "/board/"+path+".jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "update" :
			//update 수정
			try {
				//update : bno, title, content
				int bno = Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				BoardVO bvo = new BoardVO(bno, title, content);
				
				isOk = bsv.update(bvo);
				
				log.info("update"+(isOk>0?"성공":"실패")+isOk);
				if(isOk>0) {
					log.info("brd_modify"+(isOk>0?"성공":"실패")+isOk);
					request.setAttribute("brd_modify", "ok");
					destPage="list"; //내부 list 케이스를 한번 타고 실행
				}else {
					request.setAttribute("brd_modify", "fail");
					destPage="detail";
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "remove" :
			//remove 제거
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				isOk = bsv.remove(bno);
				log.info("remove"+(isOk>0?"성공":"실패")+isOk);
				destPage="list";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "searchMy" :
			// 내가 쓴 글 보기
			
			try {
				HttpSession ses = request.getSession();
				String id =  ((MemberVo) ses.getAttribute("ses")).getId();
				List<BoardVO> list = bsv.searchMy(id);
				log.info("searchMy >>> {}",list);
				request.setAttribute("list", list);
				destPage = "/board/list.jsp";
			} catch (Exception e) {
				// TODO: handle exception
			}
			

		}
		// 목적지 주소(destPage)로 데이터를 전달(RequestDispatcher)
		rdp = request.getRequestDispatcher(destPage);
		// 요청에 필요한 객체를 가지고 destPage에 적힌 경로로 이동
		rdp.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
