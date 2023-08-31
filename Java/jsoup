package com.example.demo.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EventDAO_jpa;
import com.example.demo.entity.Event;

@RestController
public class JsoupController {
    @Autowired
    private EventDAO_jpa event_jpa;

    @GetMapping("/img")
    public void newEvent() {
        ArrayList<String> tlist = new ArrayList<>(); //공연이름을 담는 list
        ArrayList<String> flist = new ArrayList<>(); //공연포스터를 담는 list

        for (int p = 1; p <= 12; p++) {
        	//페이지가 12페이지 
            String url = "https://festivallife.kr/concert_k/?q=YToyOntzOjEyOiJrZXl3b3JkX3R5cGUiO3M6MzoiYWxsIjtzOjQ6InBhZ2UiO2k6MTA7fQ%3D%3D&page=" + p + "";
            try {
                Document doc = Jsoup.connect(url).get(); // jsoup이 url와 연결해서 doucument형태로 가져온다
                Elements list = doc.getElementsByClass("title title-block"); 
                for (Element e : list) {
                    Element a = e.getElementsByTag("div").get(0); // "div"태그를 찾아주세요 (근데 무조건 배열로 주니 첫번째)
                    String title = a.text(); // 공연이름
                    title = title.substring(title.indexOf(" ") + 1, title.length());
                    //내한이라고 표기 되어있으면 잘라내고 순수한 타이틀만 가지고 온다
                    if (title.indexOf("내한") != -1) {
                        title = title.substring(0, title.indexOf("내한"));
                    }
                    tlist.add(title);
                }

                Elements cardWrappers = doc.select("[style*=background-image][class~=card_wrapper]");
                for (Element wrapper : cardWrappers) {
                    String style = wrapper.attr("style");
                    String regex = "url\\((.*?)\\)";
                    
                    Pattern pattern=Pattern.compile(regex);
                    Matcher matcher=pattern.matcher(style);
                   
                    // 배경 이미지 URL이 매칭되었다면 출력합니다.
                    if (matcher.find()) {
                        String backgroundImageURL = matcher.group(1);
                        flist.add(backgroundImageURL);
                    } else {
                        System.out.println("No match"); //포스터가 없을때 예외처리
                    }
                }

            } catch (Exception e) {
                System.out.println("크로링예외발생:" + e.getMessage());
            }
        }

        // fname과 title을 짝지어 db에 넣기
        for (int i = 0; i < flist.size(); i++) {
            String addr = flist.get(i);             
            String eventName = tlist.get(i);		//공연이름
            String eventFname = eventName + ".jpg"; //포스터 이름

            try {
                URL url = new URL(addr); //이미지 원격 위치
                InputStream is = url.openStream(); //이미지 원격 데이터 가져오기
                FileOutputStream fos = new FileOutputStream("src/main/resources/static/images/" + eventFname); //이미지 로컬 파일
                FileCopyUtils.copy(is.readAllBytes(), fos); //로컬 파일로 복사
                is.close();
                fos.close();
                
                //event 테이블에 데이터 추가
                Event event = new Event();
                event.setEventfname(eventFname);
                event.setEventhit(1);
                event.setCategoryno(2);
                event.setEventname(eventName);
                event.setEventno(i + 1);
                event_jpa.save(event);

            } catch (Exception e) {
                System.out.println("insert예외발생:" + e.getMessage());
            }
        }
    }
}
