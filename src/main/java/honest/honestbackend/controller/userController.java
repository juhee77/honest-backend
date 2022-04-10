package honest.honestbackend.controller;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class userController {
    @ResponseBody

    @RequestMapping(value="/userSave.do" , produces="application/json; charset=utf-8")  // json.do 라는 객체로
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
