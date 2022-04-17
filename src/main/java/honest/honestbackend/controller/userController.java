package honest.honestbackend.controller;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import honest.honestbackend.domain.User;
import honest.honestbackend.service.userRepository;
import honest.honestbackend.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class userController {

    @Autowired
    userService userService;
    @Autowired
    userRepository userRepository;

    @ResponseBody
    @GetMapping("/checkUserId.do")
    public User checkIdGet(String id){
        if(userRepository.findById(id)!=null){
            User user = userRepository.findById(id);
            return user;
        }
        else
            return null;
    }

    @ResponseBody //user save to DB
    @PostMapping("/userSave.do")
    public String userSavePost(User user){
        userRepository.save(user);
        return "post 성공";
    }


    @ResponseBody //참고용
    @GetMapping("/json.do")
    public String getTest(User user){
        userRepository.save(user);
        return "get 요청 받음 성공!!"+user.toString();
    }

    @ResponseBody
    @RequestMapping(value="/test" , produces="application/json; charset=utf-8")  // json.do 라는 객체로
    public JSONObject json() {
        JSONObject jsonMain=new JSONObject();										// json 객체 [{변수명:값, 변수명:값}]
        JSONArray jArray=new JSONArray();											// json 배열
        JSONObject row = new JSONObject();
        //row.put("name", "naver");
        //row.put("email", "naver@naver.com");
        //jArray.add(0, row);

        //JSONObject row2 = new JSONObject();
        //row2.put("name", "kokanry");
        //row2.put("email", "kokanry@naver.com");
        //jArray.add(1, row2);              // jArray = members에 들어갈 변수명,값들

        row.put("test","test");
        jArray.add(0,row);
        jsonMain.put("TEst", jArray);  // jsonMain = members, books, items 같은거 여러개 가능
        return jsonMain;
    }

}
