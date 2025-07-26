package webservice;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.servlet.annotation.Mapping;

import java.util.List;

import static utils.MyLogger.log;

public class MemberController {

    private final MemberRepository memberRepository;

    // 컨트롤러에서는 인터페이스 의존 (어떤 구현체가 들어올지는 런타임시에 결정됨)
    // 컨트롤러 입장에서 MemberRepository 의 인스턴스를 외부에서 주입받는 형태
    // 의존관계 주입 (DI)
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Mapping("/")
    public void home(HttpResponse response) {
        String str =
                "<html><body>" +
                        "<h1>Member Manager</h1>" +
                        "<ul>" +
                        "<li><a href='/members'>Member List</a></li>" +
                        "<li><a href='/add-member-form'>Add New Member</a></li>" +
                        "</ul>";
        response.writeBody(str);
    }

    @Mapping("/members")
    public void getMemberList(HttpResponse response) {
        List<Member> members = memberRepository.findAll();

        StringBuilder page = new StringBuilder();
        page.append("<html><body>");
        page.append("<h1>Member List</h1>");
        page.append("<ul>");

        for (Member member : members) {
            page.append("<li>")
                    .append("ID: ").append(member.getId())
                    .append(", Name: ").append(member.getName())
                    .append(", Age: ").append(member.getAge())
                    .append("</li>");
        }
        page.append("</ul>");
        page.append("<a href='/'>Back to Home</a>");
        page.append("</body></html>");
        response.writeBody(page.toString());
    }

    @Mapping("/add-member-form")
    public void addMemberForm(HttpRequest request, HttpResponse response) {
        String body = "<body><html>" +
                "<h1>Add New Member</h1>" +
                "<form method='POST' action='/add-member'>" + // 해당 url로 입력한 값들을 전달
                "ID: <input type='text' name='id'><br>" +
                "Name: <input type='text' name='name'><br>" +
                "Age: <input type='text', name='age'><br>" +
                "<input type='submit' value='Add'>" +
                "</form>" +
                "<a href='/'>Back to Home</a>" +
                "</body></html>";
        response.writeBody(body);
    }

    @Mapping("/add-member")
    public void addMember(HttpRequest request, HttpResponse response) {

        log("MemberController.addMember");
        log("request = " + request);

        // 바디에서 파싱해서 저장해놓은 파라미터들
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(id, name, age);
        memberRepository.add(member);

        response.writeBody("<h1>save ok</h1>");
        response.writeBody("<a href='/'>Back to Home</a>");
    }
}


