package com.example.howtosaydemo;

import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{

    String[] language = {"Choose a language..","English","Deutsch","Français","Italiano","日本の","中国"};
    String  select="English";

    TextToSpeech textToSpeech;
    EditText inPutText;
    Button read, quiz;
    ImageView imageView;

    Spinner spinnerSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Text to Speech");

        inPutText = findViewById(R.id.inPutText);
        read = findViewById(R.id.read);
        quiz = findViewById(R.id.quiz);
        imageView = findViewById(R.id.imageView);

        spinnerSelect = findViewById(R.id.chooseLanguage);
        spinnerSelect.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,language);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerSelect.setAdapter(arrayAdapter);

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Quiz.class);
                MainActivity.this.startActivity(intent);
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = inPutText.getText().toString();
                Toast.makeText(getApplicationContext(),""+toSpeak,Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });
    }



    public void onPause() {
        if (textToSpeech!=null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (language[position]){
            case "Choose a language..":
                imageView.setImageResource(R.drawable.tittlebild);
                inPutText.setHint("");
                break;
            case "English":
                imageView.setImageResource(R.drawable.bigben);
                textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.UK);
                        String toSpeak = "Type in text";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                inPutText.setHint("Type in text..");
                read.setText("Read"); quiz.setText("Go to Quiz");
                break;
            case "Deutsch":
                imageView.setImageResource(R.drawable.brandburgertor);
                textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.GERMAN);
                        String toSpeak = "Geben Sie den Text ein";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                inPutText.setHint("Geben Sie den Text ein..");
                read.setText("Lesen"); quiz.setText("Gehe zum Quiz");
                break;
            case "Français":
                imageView.setImageResource(R.drawable.eifeltwoer);
                textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.FRENCH);
                        String toSpeak = "Tapez le texte.";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                inPutText.setHint("Tapez le texte..");
                read.setText("Lis"); quiz.setText("Aller au quiz");
                break;
            case"Italiano":
                imageView.setImageResource(R.drawable.romstedium);
                textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.ITALIAN);
                        String toSpeak = "Digitare testo.";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                inPutText.setHint("Digitare testo..");
                read.setText("Leggere"); quiz.setText("Vai al quiz");
                break;
            case "日本の":
                imageView.setImageResource(R.drawable.torijapan);
                textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.JAPANESE);
                        String toSpeak = "テキストを入力.";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                inPutText.setHint("テキストを入力..");
                read.setText("読む"); quiz.setText("クイズに行く");
                break;
            case"中国":
                imageView.setImageResource(R.drawable.fotoliahimmelstempelpeking);
                textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.CHINESE);
                        String toSpeak = "输入文字.";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                inPutText.setHint("输入文字..");
                read.setText("读"); quiz.setText("去测验");
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}