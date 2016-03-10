import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadFile {

    private final String fileName;
    private String content;
    private FileInputStream file;

    private ReadFile(String file){
        this.fileName = file;
        this.file = null;
        this.content = "";
    }

    public static ReadFile addFile(String file) throws Exception {
        ReadFile self = new ReadFile(file);
        try{
            self.addInputStream();
            self.read();
        }
        catch(FileNotFoundException err){
            throw new Exception("ERROR.... File Not Found "+file);
        }
        catch(IOException err){
            throw new Exception("Oops... The File can't be read...");
        }
        return self;
    }

    private void addInputStream() throws FileNotFoundException{
        this.file = new FileInputStream(this.fileName);
    }

    private void read() throws IOException{
        char c[];
        int temp;
        String text;
        while((temp = this.file.read())!=-1){
            c = Character.toChars(temp);
            text = new String(c);
            this.content = this.content.concat(text);
        }
    }

    public String getContent(){
        return this.content;
    }
}