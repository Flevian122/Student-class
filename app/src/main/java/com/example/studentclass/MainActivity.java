import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextStudentId, editTextResearchTopic;
    Button buttonSubmit;

    public static final String EXTRA_NAME = "com.yourdomain.yourappname.EXTRA_NAME";
    public static final String EXTRA_STUDENT_ID = "com.yourdomain.yourappname.EXTRA_STUDENT_ID";
    public static final String EXTRA_RESEARCH_TOPIC = "com.yourdomain.yourappname.EXTRA_RESEARCH_TOPIC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextStudentId = findViewById(gitR.id.editTextStudentId);
        editTextResearchTopic = findViewById(R.id.editTextResearchTopic);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String studentId = editTextStudentId.getText().toString().trim();
                String researchTopic = editTextResearchTopic.getText().toString().trim();

                if (validateInputs(name, studentId)) {
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra(EXTRA_NAME, name);
                    intent.putExtra(EXTRA_STUDENT_ID, studentId);
                    intent.putExtra(EXTRA_RESEARCH_TOPIC, researchTopic);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateInputs(String name, String studentId) {
        if (name.isEmpty()) {
            editTextName.setError("Name cannot be empty");
            return false;
        }
        if (studentId.isEmpty()) {
            editTextStudentId.setError("ID cannot be empty");
            return false;
        }
        return true;
    }
}
