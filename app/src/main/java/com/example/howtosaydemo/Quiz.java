package com.example.howtosaydemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Locale;

public class Quiz extends AppCompatActivity {

    private final static String German1 = "Rom";
    private final static String English1 = "Paris";
    private final static String French = "London";
    private final static String Japan = "モスクワ";
    private final static String China = "卡萨布兰卡";
    private final static String Italy = "Berlin";

    static int scoreValue=0;

    TextToSpeech textToSpeech;

    Button button1, button2, button3, button4;
    Button goToRead, repeat;
    Button prev, next;

    TextView answerTxt, score, clickText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        prev = findViewById(R.id.prevButton);
        next = findViewById(R.id.nextButton);

        goToRead = findViewById(R.id.goToRead);
        repeat =  findViewById(R.id.repeat);

        answerTxt = findViewById(R.id.answer);
        score = findViewById(R.id.score);
        clickText = findViewById(R.id.clickText);

        goToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this,MainActivity.class);
                Quiz.this.startActivity(intent);
            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"There are no previous questions",Toast.LENGTH_SHORT).show();
            }
        });




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.UK);

                        String toSpeak = English1;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question2();
                    }
                });

            }
        });


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.GERMAN);
            }
        });

        clickText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.GERMAN);
                        String toSpeak = German1;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        scoreValue=0;
                        answerTxt.setText("");
                        score.setText(""+scoreValue);
                        question1();
                    }
                });



            }
        });


        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Touch The Start/Restart Text Field!",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void question1() {

        clickText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.GERMAN);
                        String toSpeak = German1;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        scoreValue=0;
                        answerTxt.setText("");
                        score.setText(""+scoreValue);
                    }
                });



            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.UK);

                        String toSpeak = English1;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question2();
                    }
                });

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerTxt.setText("");
                Toast.makeText(getApplicationContext(),"There are no previous questions",Toast.LENGTH_SHORT).show();
            }
        });


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.GERMAN);
            }
        });



        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = German1;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        button1.setText("ENGLISH");
        button1.setBackgroundResource(android.R.drawable.btn_default);
        button2.setText("GERMAN");
        button2.setBackgroundResource(android.R.drawable.btn_default);
        button3.setText("FRENCH");
        button3.setBackgroundResource(android.R.drawable.btn_default);
        button4.setText("ITALIAN");
        button4.setBackgroundResource(android.R.drawable.btn_default);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorPrimary));
                Toast.makeText(getApplicationContext(), " :) WELL DONE", Toast.LENGTH_SHORT).show();
                if (scoreValue<1) {
                    scoreValue++;
                }
                score.setText("" + scoreValue);
                answerTxt.setText(German1);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void question2() {

        clickText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.GERMAN);
                        String toSpeak = German1;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        scoreValue=0;
                        answerTxt.setText("");
                        score.setText(""+scoreValue);
                        question1();
                    }
                });



            }
        });

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.UK);
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = English1;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.ITALIAN);

                        String toSpeak = Italy;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question3();
                    }
                });

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.GERMAN);

                        String toSpeak = German1;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question1();
                    }
                });

            }
        });


        button1.setText("ENGLISH");
        button1.setBackgroundResource(android.R.drawable.btn_default);
        button2.setText("GERMAN");
        button2.setBackgroundResource(android.R.drawable.btn_default);
        button3.setText("JAPANESE");
        button3.setBackgroundResource(android.R.drawable.btn_default);
        button4.setText("CHINESE");
        button4.setBackgroundResource(android.R.drawable.btn_default);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorPrimary));
                Toast.makeText(getApplicationContext(), " :) WELL DONE", Toast.LENGTH_SHORT).show();
                if (scoreValue<2) {
                    scoreValue++;
                }
                score.setText("" + scoreValue);
                answerTxt.setText(English1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void question3() {

        clickText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.GERMAN);
                        String toSpeak = German1;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        scoreValue=0;
                        answerTxt.setText("");
                        score.setText(""+scoreValue);
                        question1();
                    }
                });



            }
        });

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.ITALIAN);
            }
        });


        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = Italy;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.CHINESE);

                        String toSpeak = China;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question4();
                    }
                });

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.UK);

                        String toSpeak = English1;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question2();
                    }
                });

            }
        });

        button1.setText("JAPANESE");
        button1.setBackgroundResource(android.R.drawable.btn_default);
        button2.setText("GERMAN");
        button2.setBackgroundResource(android.R.drawable.btn_default);
        button3.setText("ITALIAN");
        button3.setBackgroundResource(android.R.drawable.btn_default);
        button4.setText("CHINESE");
        button4.setBackgroundResource(android.R.drawable.btn_default);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorPrimary));
                Toast.makeText(getApplicationContext(), " :) WELL DONE", Toast.LENGTH_SHORT).show();
                if (scoreValue<3) {
                    scoreValue++;
                }
                score.setText("" + scoreValue);
                answerTxt.setText(Italy);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void question4() {

        clickText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.GERMAN);
                        String toSpeak = German1;
                        textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_ADD, null);
                        scoreValue=0;
                        answerTxt.setText("");
                        score.setText(""+scoreValue);
                        question1();
                    }
                });



            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.JAPANESE);

                        String toSpeak = Japan;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question5();
                    }
                });

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.ITALIAN);

                        String toSpeak = Italy;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question3();
                    }
                });

            }
        });

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.CHINESE);
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = China;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        button1.setText("CHINESE");
        button1.setBackgroundResource(android.R.drawable.btn_default);
        button2.setText("GERMAN");
        button2.setBackgroundResource(android.R.drawable.btn_default);
        button3.setText("JAPANESE");
        button3.setBackgroundResource(android.R.drawable.btn_default);
        button4.setText("ENGLISH");
        button4.setBackgroundResource(android.R.drawable.btn_default);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorPrimary));
                Toast.makeText(getApplicationContext(), " :) WELL DONE", Toast.LENGTH_SHORT).show();
                if (scoreValue<4) {
                    scoreValue++;
                }
                score.setText("" + scoreValue);
                answerTxt.setText(China);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void question5() {

        clickText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.GERMAN);
                        String toSpeak = German1;
                        textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_ADD, null);
                        scoreValue=0;
                        answerTxt.setText("");
                        score.setText(""+scoreValue);
                        question1();
                    }
                });



            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.FRENCH);

                        String toSpeak = French;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question6();
                    }
                });

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.CHINESE);

                        String toSpeak = China;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question3();
                    }
                });

            }
        });

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.JAPANESE);
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = Japan;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });


        button1.setText("ITALIAN");
        button1.setBackgroundResource(android.R.drawable.btn_default);
        button2.setText("GERMAN");
        button2.setBackgroundResource(android.R.drawable.btn_default);
        button3.setText("JAPANESE");
        button3.setBackgroundResource(android.R.drawable.btn_default);
        button4.setText("CHINESE");
        button4.setBackgroundResource(android.R.drawable.btn_default);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorPrimary));
                Toast.makeText(getApplicationContext(), " :) WELL DONE", Toast.LENGTH_SHORT).show();
                if (scoreValue<5) {
                    scoreValue++;
                }
                score.setText("" + scoreValue);
                answerTxt.setText(Japan);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void question6() {

        clickText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.GERMAN);
                        String toSpeak = German1;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        scoreValue=0;
                        answerTxt.setText("");
                        score.setText(""+scoreValue);
                        question1();
                    }
                });



            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerTxt.setText("");
                Toast.makeText(getApplicationContext(),"You have finished your quiz!",Toast.LENGTH_SHORT).show();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.JAPANESE);

                        String toSpeak = Japan;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                        } else {
                            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                        }
                        answerTxt.setText("");
                        question5();
                    }
                });

            }
        });

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.FRENCH);
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = French;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        button1.setText("CHINESE");
        button1.setBackgroundResource(android.R.drawable.btn_default);
        button2.setText("GERMAN");
        button2.setBackgroundResource(android.R.drawable.btn_default);
        button3.setText("JAPANESE");
        button3.setBackgroundResource(android.R.drawable.btn_default);
        button4.setText("FRENCH");
        button4.setBackgroundResource(android.R.drawable.btn_default);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorAccent));
                Toast.makeText(getApplicationContext(), " :( Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setBackgroundColor(ContextCompat.getColor(Quiz.this,
                        R.color.colorPrimary));
                Toast.makeText(getApplicationContext(), " :) WELL DONE", Toast.LENGTH_SHORT).show();
                if (scoreValue<6) {
                    scoreValue++;
                }
                score.setText("" + scoreValue);
                answerTxt.setText(French);
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


}