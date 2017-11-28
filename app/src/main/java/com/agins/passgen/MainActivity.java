package com.agins.passgen;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Switch;
        import android.widget.CompoundButton;
        import java.security.SecureRandom;
        import android.content.ClipboardManager;
        import android.widget.Toast;
        import android.content.pm.ActivityInfo;
        import android.content.Intent;
        import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    // Hi! This is my GovnoCode
    // Remember: suicide is not the answer
    boolean numEn = true;
    boolean letEn = true;
    boolean symEn = false;
    boolean numOff = false;
    boolean letOff = false;
    boolean symOff = true;
    String passOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Switch numsw = (Switch) findViewById(R.id.numsw);
        // устанавливаем переключатель программно в значение ON
        numsw.setChecked(true);
        // добавляем слушателя
        numsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // в зависимости от значения isChecked выводим нужное сообщение
                if (isChecked) {
                    numEn = true;
                    numOff = false;
                } else {
                    if ((symOff==true)&&(letOff==true)){
                        Toast.makeText(getApplicationContext(), "You can off all mode", Toast.LENGTH_SHORT).show();
                        numEn = true;
                        Switch numsw = (Switch) findViewById(R.id.numsw);
                        numsw.setChecked(true);
                    } else {numEn = false;  numOff = true;}
                }
            }
        });

        final Switch letsw = (Switch) findViewById(R.id.letsw);
        letsw.setChecked(true);
        // добавляем слушателя
        letsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    letEn = true;
                    letOff = false;
                } else {

                    if ((symOff==true)&&(numOff==true)){
                        Toast.makeText(getApplicationContext(), "You can off all mode", Toast.LENGTH_SHORT).show();
                        letEn = true;
                        Switch letsw = (Switch) findViewById(R.id.letsw);
                        letsw.setChecked(true);
                    } else {letEn = false; letOff =true;}
                }
            }
        });

        Switch symsw = (Switch) findViewById(R.id.symsw);
        symsw.setChecked(false);
        // добавляем слушателя
        symsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    symEn = true;
                    symOff = false;
                    Toast.makeText(getApplicationContext(), "This mode may not work everywhere", Toast.LENGTH_SHORT).show();
                } else {
                    if ((letOff==true)&&(numOff==true)){
                        Toast.makeText(getApplicationContext(), "You can off all mode", Toast.LENGTH_SHORT).show();
                        symEn = true;
                        Switch symsw = (Switch) findViewById(R.id.symsw);
                        symsw.setChecked(true);
                    } else {symEn = false; symOff =true;}
                }
            }
        });

    }

    public void Gen(View v) {
        EditText num = (EditText) findViewById(R.id.passLength);
        EditText passOutText = (EditText) findViewById(R.id.passout);
        passOutText.setText("");
        passOut="";
        for (int much =  Integer.parseInt(num.getEditableText().toString()); much!=0; much=much-1) {
            SecureRandom nlsR = new SecureRandom();
            int nls = nlsR.nextInt(3);
            switch (nls) {
                case 0:
                    if (numEn == true) {
                        NumGen();
                    }else{much=much+1;}
                    break;
                case 1:
                    if (letEn == true) {
                        LetGen();
                    }else{much=much+1;}
                    break;
                case 2: if (symEn == true) {
                    SymGen();
                }else{much=much+1;}
                    break;

            }
        }
        passOutText.setText(passOut);
    }

    private void NumGen(){
        SecureRandom numR = new SecureRandom();
        int num = numR.nextInt(10);
        passOut = passOut + num;
    }

    private void LetGen(){
        char letter;
        SecureRandom letR = new SecureRandom();
        int let= letR.nextInt(52);
        letter = ' ';
        switch (let) {
            case 0: letter='Q';
                break;
            case 1: letter='W';
                break;
            case 2: letter='E';
                break;
            case 3: letter='R';
                break;
            case 4: letter='T';
                break;
            case 5: letter='Y';
                break;
            case 6: letter='U';
                break;
            case 7: letter='I';
                break;
            case 8: letter='O';
                break;
            case 9: letter='P';
                break;
            case 10: letter='A';
                break;
            case 11: letter='S';
                break;
            case 12: letter='D';
                break;
            case 13: letter='F';
                break;
            case 14: letter='G';
                break;
            case 15: letter='H';
                break;
            case 16: letter='J';
                break;
            case 17: letter='K';
                break;
            case 18: letter='L';
                break;
            case 19: letter='Z';
                break;
            case 20: letter='X';
                break;
            case 21: letter='C';
                break;
            case 22: letter='V';
                break;
            case 23: letter='B';
                break;
            case 24: letter='N';
                break;
            case 25: letter='M';
                break;
            case 26: letter='q';
                break;
            case 27: letter='w';
                break;
            case 28: letter='e';
                break;
            case 29: letter='r';
                break;
            case 30: letter='t';
                break;
            case 31: letter='y';
                break;
            case 32: letter='u';
                break;
            case 33: letter='i';
                break;
            case 34: letter='o';
                break;
            case 35: letter='p';
                break;
            case 36: letter='a';
                break;
            case 37: letter='s';
                break;
            case 38: letter='d';
                break;
            case 39: letter='f';
                break;
            case 40: letter='g';
                break;
            case 41: letter='h';
                break;
            case 42: letter='j';
                break;
            case 43: letter='k';
                break;
            case 44: letter='l';
                break;
            case 45: letter='z';
                break;
            case 46: letter='x';
                break;
            case 47: letter='c';
                break;
            case 48: letter='v';
                break;
            case 49: letter='b';
                break;
            case 50: letter='n';
                break;
            case 51: letter='m';
                break;
        }
        passOut = passOut + letter;

    }

    public void SymGen(){
        char symbol;
        SecureRandom letR = new SecureRandom();
        int let= letR.nextInt(15);
        symbol = ' ';
        switch (let) {
            case 0:
                symbol = '`';
                break;
            case 1:
                symbol = '!';
                break;
            case 2:
                symbol = '@';
                break;
            case 3:
                symbol = '$';
                break;
            case 4:
                symbol = '%';
                break;
            case 5:
                symbol = '^';
                break;
            case 6:
                symbol = '&';
                break;
            case 7:
                symbol = '*';
                break;
            case 8:
                symbol = '(';
                break;
            case 9:
                symbol = ')';
                break;
            case 10:
                symbol = '-';
                break;
            case 11:
                symbol = '_';
                break;
            case 12:
                symbol = '+';
                break;
            case 13:
                symbol = '=';
                break;
            case 14:
                symbol = '~';
                break;
        }
        passOut = passOut + symbol;
    }

    public void Copy(View v) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        clipboard.setText(passOut);
        Toast.makeText(getApplicationContext(), "Copied", Toast.LENGTH_SHORT).show();
    }

    public void GitHub(View v){
        Uri address = Uri.parse("https://vk.com");
        Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openlinkIntent);
    }
}
