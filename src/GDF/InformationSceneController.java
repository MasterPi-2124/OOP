
package GDF;

import java.net.URL;
import java.util.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.transform.Affine;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class InformationSceneController implements Initializable {

    @FXML
    private TextArea helpTextArea,
                     aboutTextArea;
    @FXML
    private WebView markdownHelp,
    				markdownAbout;

    public List<String> read(File file) {
        List<String> lines = new ArrayList<String>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (IOException ex) {

        }

        return lines;
    }

    private WebView markdown(TextArea inputArea, WebView browser) {

    	inputArea.setPrefSize(800, 200);
    	inputArea.setWrapText(true);
    	TextArea htmlArea = new TextArea();
    	htmlArea.setWrapText(true);
    	WebEngine webEngine = browser.getEngine();

    	String header = "<html>\n<body>\n";
    	String footer = "</body>\n</html>\n";
    	String originalText = inputArea.getText();

    	Scanner scan = new Scanner(originalText);
    	String modifiedText = "";

    	while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if(line.startsWith("# ")) {
				line = line.substring(2);
				modifiedText += "<h1>" + line + "</h1> \n";
			} else if(line.startsWith("## ")) {
				line = line.substring(3);
				modifiedText += "<h2>" + line + "</h2> \n";
			} else if(line.startsWith("### ")) {
				line = line.substring(4);
				modifiedText += "<h3>" + line + "</h3> \n";
			} else if(line.startsWith("---")) {
				modifiedText += "<hr /> \n";
			} else {
				modifiedText += line + "<br /> \n";
			}
		}
    	System.out.println(modifiedText);

    	String [] symbols = {"**", "``", "--", "~~"};
    	String [] tagNames = {"b", "i", "u", "s"};
    	for(int i = 0; i <symbols.length; i++) {
    		String symbol = symbols[i];
    		String tagName = tagNames[i];
    		boolean tagStart = true;
    		while (modifiedText.contains(symbol)) {
				int index = modifiedText.indexOf(symbol);

				String beforeSymbol =
						modifiedText.substring(0, index);
				String afterSymbol =
						modifiedText.substring(index + 2);

				String tag;
				if(tagStart) {
					tag = "<" + tagName + ">";
				} else {
					tag  = "</" + tagName + ">";
				}

				modifiedText = beforeSymbol + tag + afterSymbol;

				tagStart = !tagStart;
    		}
    	}
    	String content = header + modifiedText + footer;
    	htmlArea.setText(content);
    	webEngine.loadContent(content);
    	return browser;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        for (String line : read(new File("src/file/help.md")) ) {
            helpTextArea.appendText(line + "\n");
        }
        setMarkdownHelp(markdown(helpTextArea, markdownHelp));


        for (String line : read(new File("src/file/about.md")) ) {
            aboutTextArea.appendText(line + "\n");
        }
        setMarkdownAbout(markdown(aboutTextArea, markdownAbout));



    }

	public WebView getMarkdownAbout() {
		return markdownAbout;
	}

	public void setMarkdownAbout(WebView markdownAbout) {
		this.markdownAbout = markdownAbout;
	}

	public WebView getMarkdownHelp() {
		return markdownHelp;
	}

	public void setMarkdownHelp(WebView markdownHelp) {
		this.markdownHelp = markdownHelp;
	}
}
