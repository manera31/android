package com.joanmanera.gmail;

import android.content.Context;
import android.util.JsonToken;

import com.joanmanera.gmail.models.Acount;
import com.joanmanera.gmail.models.Contact;
import com.joanmanera.gmail.models.Mail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GmailParser {
    private Acount acount;
    private ArrayList<Contact> contacts;
    private ArrayList<Mail> mail;
    private InputStream mailsFile;

    public GmailParser (Context context){
        this.mailsFile = context.getResources().openRawResource(R.raw.correos);
    }

    public boolean parse(){
        boolean parsed;
        String jsonMails;

        try {
            byte[] buffer = new byte[mailsFile.available()];
            mailsFile.read(buffer);
            mailsFile.close();
            jsonMails = new String(buffer, "UTF-8");

            JSONTokener tokener = new JSONTokener(jsonMails);
            JSONObject objectAcount = new JSONObject(tokener);
            JSONObject ob2 = objectAcount.getJSONObject("myAccout");

            int id = ob2.getInt("id");
            String name = ob2.getString("name");
            String firstSurname = ob2.getString("firstSurname");
            String email = ob2.getString("email");

            acount = new Acount(id, name, firstSurname, email);

            //CONTACTOS
            JSONArray arrayContacts = objectAcount.getJSONArray("contacts");
            for (int i = 0 ; i < arrayContacts.length() ; i++){
                JSONObject contactObject = arrayContacts.getJSONObject(i);
                int idContact;
                String nameContact;
                String firstSurnameContact;
                String secondSurnameContact;
                String birth;
                int photo;
                String emailContact;
                String phone1;
                String phone2;
                String address;
                idContact = contactObject.getInt("id");
                nameContact = contactObject.getString("name");
                firstSurnameContact = contactObject.getString("firstSurname");
                secondSurnameContact = contactObject.getString("secondSurname");
                birth = contactObject.getString("birth");
                photo = contactObject.getInt("foto");
                emailContact = contactObject.getString("email");
                phone1 = contactObject.getString("phone1");
                phone2 = contactObject.getString("phone2");
                address = contactObject.getString("address");

            }

            //MAILS
            JSONArray arrayMail = objectAcount.getJSONArray("mails");
            for (int i = 0 ; i < arrayMail.length() ; i++){
                JSONObject mailObject = arrayMail.getJSONObject(i);
                String from;
                String to;
                String subject;
                String body;
                String sentOn;
                boolean readed;
                boolean deleted;
                boolean spam;
                from = mailObject.getString("from");
                to = mailObject.getString("to");
                subject = mailObject.getString("subject");
                body = mailObject.getString("body");
                sentOn = mailObject.getString("sentOn");
                readed = mailObject.getBoolean("readed");
                deleted = mailObject.getBoolean("deleted");
                spam = mailObject.getBoolean("spam");
            }
            parsed = true;
        } catch (IOException e) {
            e.printStackTrace();
            parsed = false;
        } catch (JSONException e) {
            e.printStackTrace();
            parsed = false;
        }

        return parsed;
    }
}
