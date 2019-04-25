package = com.nehouse.nehouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PasswordChanging extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_changing);
    }

    public void PasswordChangingConfirm (View view) {
        Intent intent = new Intent(PasswordChanging.this, MainActivity.class);
        startActivity(intent);
    }
}
