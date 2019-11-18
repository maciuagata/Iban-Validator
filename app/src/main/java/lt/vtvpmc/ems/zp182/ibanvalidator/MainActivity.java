package lt.vtvpmc.ems.zp182.ibanvalidator;


import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText ibanField;
    private Button checkIban;
    private TextView validate;
    private Button checkFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibanField = (EditText) findViewById(R.id.ibanField);
        checkIban = (Button) findViewById(R.id.checkIban);
        validate = (TextView) findViewById(R.id.validate);
        checkFile = (Button) findViewById(R.id.checkFile); 

        checkIban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInputValue = ibanField.getText().toString();
                IbanTest test = new IbanTest();
                boolean result = test.Iban(userInputValue);
                String result1 = String.valueOf(result);
                validate.setText(result1);
            }
        });

        checkFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInputValue = ibanField.getText().toString();
                IbanTest test = new IbanTest();
                boolean result = test.Iban(userInputValue);
                String result1 = String.valueOf(result);
                validate.setText(result1);
            }

            class FilesUtil {
                @RequiresApi(api = Build.VERSION_CODES.O)
                public String readTextFile(String fileName) throws IOException {
                    String content = new String(Files.readAllBytes(Paths.get(fileName)));
                    return content;
                }

                @RequiresApi(api = Build.VERSION_CODES.O)
                public List<String> readTextFileByLines(String fileName) throws IOException {
                    List<String> lines = Files.readAllLines(Paths.get(fileName));
                    return lines;
                }
                @RequiresApi(api = Build.VERSION_CODES.O)
                public void writeToTextFile(String fileName, String content) throws IOException {
                    Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE);
                }

            }
        });

    }
}