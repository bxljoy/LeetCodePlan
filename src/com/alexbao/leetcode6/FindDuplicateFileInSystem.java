package com.alexbao.leetcode6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> contentMap = new HashMap<>();
        for (int i=0; i<paths.length; i++) {
            String[] contents = paths[i].split(" ");
            String path = contents[0];
            for (int j=1; j<contents.length; j++) {
                String[] files = contents[j].split("\\(");
                String fileName = files[0];
                String content = files[1].split("\\)")[0];
                List<String> oldContent = new ArrayList<>();
                oldContent = contentMap.getOrDefault(content, oldContent);
                oldContent.add(path + "/" + fileName);
                contentMap.put(content, oldContent);
            }
        }
        for (List<String> list : contentMap.values()) {
            if (list.size() > 1) {
                res.add(list);
            }
        }
        return res;
    }
}
