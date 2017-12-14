package pl.sarseth.lotrchallanger.model.data.downloader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class QuestDownloader extends JsonDownloader {

    private static final String QUEST_URL = "http://TOP SECRET.com/Export/Scenarios";

    public static void main(String... args) throws IOException {
        new QuestDownloader().downloadQuestsAndSaveToFile();
    }

    private void downloadQuestsAndSaveToFile() throws IOException {
        JSONArray questJson = downloadJsonFromUrl(QUEST_URL);
        for (Object o : questJson) {
            ((JSONObject) o).remove("ScenarioCards");
            ((JSONObject) o).remove("QuestCards");
        }
        System.out.println(questJson.toString());
    }

}
