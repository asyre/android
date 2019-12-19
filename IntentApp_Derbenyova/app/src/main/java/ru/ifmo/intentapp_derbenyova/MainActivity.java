package ru.ifmo.intentapp_derbenyova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_call).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+7 981 919 27 18"));
                if (isIntentSafe(callIntent))
                    startActivity(callIntent);
                else
                    Toast.makeText(getApplicationContext(), "Your phone have no app can dial",
                            Toast.LENGTH_SHORT).show();
            }

        });

        findViewById(R.id.button_map).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                if (isIntentSafe(mapIntent))
                    startActivity(mapIntent);
                else
                    Toast.makeText(getApplicationContext(), "Your phone have no app can map",
                            Toast.LENGTH_SHORT).show();
            }

        });

        findViewById(R.id.button_web).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String url = "https://www.reddit.com/";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                if (isIntentSafe(browserIntent))
                    startActivity(browserIntent);
                else
                    Toast.makeText(getApplicationContext(), "Your phone have no app can serf",
                            Toast.LENGTH_SHORT).show();

            }

        });

        findViewById(R.id.button_mail).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String uriText =
                        "mailto:katderbi@gmail.com" +
                                "?subject=" + Uri.encode("IntentApp") +
                                "&body=" + Uri.encode("Hello from app!");

                Uri uri = Uri.parse(uriText);
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                if (isIntentSafe(sendIntent))
                    startActivity(sendIntent);
                else
                    Toast.makeText(getApplicationContext(), "Your phone have no app can mail",
                            Toast.LENGTH_SHORT).show();
                startActivity(Intent.createChooser(sendIntent, "Send email"));
            }

        });

    }

    private boolean isIntentSafe(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return activities.size() > 0;
    }
}
