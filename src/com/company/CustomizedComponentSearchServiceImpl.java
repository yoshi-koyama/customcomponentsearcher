package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomizedComponentSearchServiceImpl implements CustomizedComponentSearchService {

    @Override
    public List<SearchResult> execute(String tenantName) throws Exception {

        String basePathFormat = "/Users/user/Documents/customcomponentsearcher/ntd/%1$s/ui.apps/%1$s/components";

        String basePath = String.format(basePathFormat, tenantName);
        String contentPath = basePath + "/content";
        String formPath = basePath + "/form";
        String structurePath = basePath + "/structure";
        List<com.company.SearchResult> searchResults = new ArrayList<>();

        searchResults.addAll(search(contentPath));
        searchResults.addAll(search(formPath));
        searchResults.addAll(search(structurePath));

        searchResults.stream().forEach(searchResult -> searchResult.setTenantName(tenantName));

        return searchResults;

    }

    private List<SearchResult> search(String searchPath) throws IOException {
        List<com.company.SearchResult> searchResults = new ArrayList<>();
        File[] componentDirectories = Paths.get(searchPath).toFile().listFiles();
        for (File componentDirectory : componentDirectories) {
            if (componentDirectory.isDirectory()) {

                com.company.SearchResult searchResult = new SearchResult();

                // slingResourceSuperTypeを抽出


                // htlのカスタム判定
                File[] htmlFiles = componentDirectory.listFiles((file, filename) -> filename.endsWith("html"));
                boolean havingHtml = htmlFiles.length >= 1;
                searchResult.setHavingHtml(havingHtml);

                // htmlファイルがある場合は中身を検索してcoreコンポーネント以外を利用しているかを調べる。
                for (File html : htmlFiles) {
                    List<String> htmlTexts = Files.readAllLines(html.toPath());
                }

                // dialogueのカスタム判定
                File[] dialogues = componentDirectory.listFiles((file, filename) -> file.isDirectory() && (filename.equals("_cq_dialogue") || filename.equals("_cq_design_dialogue")));
                boolean havingDialogue = dialogues.length >= 1;
                searchResult.setHavingDialogue(havingDialogue);

                // clientlibsのカスタム判定
                List<Path> xmlFilePaths = Files.find(componentDirectory.toPath(), 3, (path, basicFileAttributes) -> basicFileAttributes.isRegularFile() && path.getFileName().toString().equals(".content.xml")).collect(Collectors.toList());
                for (Path xmlFilePath : xmlFilePaths) {
                    List<String> xmlFileContents = Files.readAllLines(xmlFilePath);
                    boolean havingClientLibsFolder = xmlFileContents.stream().anyMatch(content -> content.contains("cq:ClientLibraryFolder"));
                    searchResult.setHavingClientLibrary(havingClientLibsFolder);
                }
                searchResults.add(searchResult);
            }
        }
        return searchResults;
    }
}
