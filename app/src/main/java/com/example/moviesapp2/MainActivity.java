package com.example.moviesapp2;

import static android.content.ContentValues.TAG;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ArrayList<Item> items;
    NewAdapter newAdapter;
    SearchView searchView;
    TextView descriptionView;
    Element words;
    Button web;


    private Animation buttonAnim;
    private Button bAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        searchView = findViewById(R.id.searchview);
        
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newAdapter.getFilter().filter(newText);
                return false;
            }
        });

        RecyclerView recyclerView = findViewById(R.id.myrecyclerview);
        newAdapter = new NewAdapter(getApplicationContext(), dataqueue());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(newAdapter);

        web=(Button)findViewById(R.id.web_button);
        web.setOnClickListener(v -> {
            Intent web = new Intent(getApplicationContext(), WebActivity2.class);
            startActivity(web);
        });
    }

    private void init(){
        buttonAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.kinopoisk_anim);
        bAnim = findViewById(R.id.web_button);
        bAnim.startAnimation(buttonAnim);
    }

    public ArrayList<Item> dataqueue(){
        ArrayList<Item> holder = new ArrayList<>();

        Item item1 = new Item();
        item1.setTitle("Интерстеллар");
        item1.setGenre("Драма, фантастика");
        item1.setRating("9.2");
        item1.setImage(R.drawable.interstellar_2014);
        item1.setDescription("Когда засуха, пыльные бури и вымирание растений приводят человечество к продовольственному кризису, коллектив исследователей и учёных отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешествий человека и найти планету с подходящими для человечества условиями.");
        holder.add(item1);

        Item item2 = new Item();
        item2.setTitle("Легенда");
        item2.setGenre("Боевик");
        item2.setRating("8.6");
        item2.setDescription("Фильм расскажет историю близнецов Реджи и Ронни Крэй, культовых фигур преступного мира Великобритании 1960-х. Братья возглавляли самую влиятельную бандитскую группировку Ист-Энда. В их послужном списке: вооруженные грабежи, рэкет, поджоги, покушения, убийства и собственный ночной клуб, куда доезжали даже голливудские знаменитости. Среди их жертв — криминальные авторитеты Джек МакВитти и Джордж Корнелл.");
        item2.setImage(R.drawable.legend);

        holder.add(item2);

        Item item3 = new Item();
        item3.setTitle("21-25");
        item3.setGenre("Драма");
        item3.setRating("7.9");
        item3.setDescription("По сюжету 4 серии дорамы «Двадцать пять, двадцать один» Хи До вынужденно заключает сделку с Чжи Вуном. В то же самое время И Чжин оказывается в затруднительной и унизительной ситуации. Между тем приближается время проведения оценочного матча национальной сборной.");
        item3.setImage(R.drawable.tt);
        holder.add(item3);

        Item item4 = new Item();
        item4.setTitle("Гарри Поттер");
        item4.setGenre("Приключения");
        item4.setRating("8.8");
        item4.setDescription("Жизнь десятилетнего Гарри Поттера нельзя назвать сладкой: родители умерли, едва ему исполнился год, а от дяди и тёти, взявших сироту на воспитание, достаются лишь тычки да подзатыльники. Но в одиннадцатый день рождения Гарри всё меняется. Странный гость, неожиданно появившийся на пороге, приносит письмо, из которого мальчик узнаёт, что на самом деле он - волшебник и зачислен в школу магии под названием Хогвартс. А уже через пару недель Гарри будет мчаться в поезде Хогвартс-экспресс навстречу новой жизни, где его ждут невероятные приключения, верные друзья и самое главное — ключ к разгадке тайны смерти его родителей.");
        item4.setImage(R.drawable.harry_potter);
        holder.add(item4);

        Item item5 = new Item();
        item5.setTitle("Семь жизней");
        item5.setGenre("Драма");
        item5.setRating("8.9");
        item5.setDescription("Инженер Бен отправляется в необычное путешествие. В ходе своей поездки он встречает семерых незнакомцев, включая смертельно больную Эмили, которая называет себя девушкой с подбитыми крыльями. Бен неожиданно влюбляется в нее, что сильно усложняет его первоначальный план. Сможет ли он разгадать послание судьбы?");
        item5.setImage(R.drawable.seven_pounds);
        holder.add(item5);

        Item item6 = new Item();
        item6.setTitle("Звёздные войны");
        item6.setGenre("Экшен, фантастика");
        item6.setRating("7.5");
        item6.setDescription("Мирная и процветающая планета Набу. Торговая федерация, не желая платить налоги, вступает в прямой конфликт с королевой Амидалой, правящей на планете, что приводит к войне. На стороне королевы и республики в ней участвуют два рыцаря-джедая: учитель и ученик, Квай-Гон-Джин и Оби-Ван Кеноби...");
        item6.setImage(R.drawable.starwars);
        holder.add(item6);

        Item item7 = new Item();
        item7.setTitle("Джон Уик");
        item7.setGenre("Боевик");
        item7.setRating("8.2");
        item7.setDescription("Джон Уик - на первый взгляд, самый обычный среднестатистический американец, который ведет спокойную мирную жизнь. Однако мало кто знает, что он был наёмным убийцей, причём одним из лучших профессионалов в своём деле.\n" +
                "\n" +
                "После того как сынок главы бандитской группы со своими приятелями угоняет его любимый «Мустанг» 1969 года выпуска, при этом убив его собаку Дейзи, которая была подарком недавно почившей супруги, Джон вынужден вернуться к своему прошлому. Теперь Уик начинает охоту за теми, кто имел неосторожность перейти ему дорогу, и он готов на всё, чтобы отомстить.");
        item7.setImage(R.drawable.john_wick);
        holder.add(item7);

        Item item8 = new Item();
        item8.setTitle("Властелин Колец");
        item8.setGenre("Приключения");
        item8.setRating("7.1");
        item8.setDescription("Сказания о Средиземье — это хроника Великой войны за Кольцо, длившейся не одну тысячу лет. Тот, кто владел Кольцом, получал неограниченную власть, но был обязан служить злу.\n" +
                "\n" +
                "Тихая деревня, где живут хоббиты. Придя на 111-й день рождения к своему старому другу Бильбо Бэггинсу, волшебник Гэндальф начинает вести разговор о кольце, которое Бильбо нашел много лет назад. Это кольцо принадлежало когда-то темному властителю Средиземья Саурону, и оно дает большую власть своему обладателю. Теперь Саурон хочет вернуть себе власть над Средиземьем. Бильбо отдает Кольцо племяннику Фродо, чтобы тот отнёс его к Роковой Горе и уничтожил.");
        item8.setImage(R.drawable.kingofrings);
        holder.add(item8);

        Item item9 = new Item();
        item9.setTitle("Зеленая книга");
        item9.setGenre("Драма");
        item9.setRating("8.9");
        item9.setDescription("1960-е годы. После закрытия нью-йоркского ночного клуба на ремонт вышибала Тони по прозвищу Болтун ищет подработку на пару месяцев. Как раз в это время Дон Ширли — утонченный светский лев, богатый и талантливый чернокожий музыкант, исполняющий классическую музыку — собирается в турне по южным штатам, где ещё сильны расистские убеждения и царит сегрегация. Он нанимает Тони в качестве водителя, телохранителя и человека, способного решать текущие проблемы. У этих двоих так мало общего, и эта поездка навсегда изменит жизнь обоих.");
        item9.setImage(R.drawable.greenbook);
        holder.add(item9);

        Item item10 = new Item();
        item10.setTitle("Атака титанов");
        item10.setGenre("Аниме");
        item10.setRating("8.6");
        item10.setDescription("Уже многие годы человечество ведёт борьбу с титанами — огромными существами, которые не обладают особым интеллектом, зато едят людей и получают от этого удовольствие. После продолжительной борьбы остатки человечества построили высокую стену, окружившую страну людей, через которую титаны пройти не могли. С тех пор прошло сто лет, люди мирно живут под защитой стены. Но однажды подросток Эрэн и его сводная сестра Микаса становятся свидетелями страшного события — участок стены разрушается супертитаном, появившимся прямо из воздуха. Титаны нападают на город, и дети в ужасе видят, как один из монстров заживо съедает их мать. Эрэн клянётся, что убьёт всех титанов и отомстит за человечество.");
        item10.setImage(R.drawable.titan_attack);
        holder.add(item10);

        return holder;
    }

    public void openProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }


}