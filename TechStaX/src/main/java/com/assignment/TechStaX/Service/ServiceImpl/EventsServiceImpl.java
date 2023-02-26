package com.assignment.TechStaX.Service.ServiceImpl;

import com.assignment.TechStaX.Entity.Commit;
import com.assignment.TechStaX.Entity.Event;
import com.assignment.TechStaX.Service.EventsService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EventsServiceImpl implements EventsService {

    @Override
    public Event eventsLog(String str){
        Event event = new Event();
        try {
            JSONObject jsonObject = new JSONObject(str);
            String a = "";
            if(jsonObject.has("pull_request")){
                event.setEventType("Pull");
            }
            else{
                event.setEventType("Push/Merge");
            }
            event.setUsername(jsonObject.getJSONObject("sender").getString("login"));
            event.setProfileURL(jsonObject.getJSONObject("sender").getString("html_url"));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return event;
    }

    @Override
    public List<Commit> commitLog() {
        List<Commit> list= new ArrayList<>();
        String CommitURL = "https://api.github.com/repos/amanbudhrani17/dummy-github-events/commits";
        List<Map<String, String>> commitList = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(CommitURL)).build();
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            String str = httpResponse.body();
            JSONArray list1 = new JSONArray(str);
            for(int i=0; i<list1.length(); i++){
                JSONObject jsonObject = list1.getJSONObject(i);
                Commit commit = new Commit();
                commit.setUsername(jsonObject.getJSONObject("author").getString("login"));
                commit.setProfileURL(jsonObject.getJSONObject("author").getString("html_url"));
                commit.setCommitURL(jsonObject.getString("html_url"));
                commit.setMessage(jsonObject.getJSONObject("commit").getString("message"));
                list.add(commit);
            }
        } catch (IOException | InterruptedException | JSONException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
