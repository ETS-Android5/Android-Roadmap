package com.example.androidroadmap;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    RecyclerView mainMenuRecView;
    private AdapterMainMenu adapterMainMenu;
    ConstraintLayout mainMenuParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.abs_layout);


        adapterMainMenu = new AdapterMainMenu(this);
        mainMenuRecView = findViewById(R.id.mainMenuRecView);
        mainMenuParent = findViewById(R.id.mainMenuParent);



        AnimationDrawable animationDrawable = (AnimationDrawable) mainMenuParent.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();



        ArrayList<ItemsMainMenu> itemsMainMenu = new ArrayList<>();

        itemsMainMenu.add(new ItemsMainMenu("1. Pick a language", R.drawable.pick_a_language, "This is the first and most important step in the field of android development. You should choose " +
                "between Java and Kotlin. Java is old and reliable language with a vast community of developers while Kotlin is new in android development which is growing very fast. \nNote - We'll " +
                "assume that you have picked Java."));
        itemsMainMenu.add(new ItemsMainMenu("2. Learn the fundamentals", R.drawable.fundamentals,"In this step, you have to learn basic programming concepts of Java and android " +
                "starting with Hello World, Basics of OOP, Data Structures and Algorithms and work your way up to apps that schedule jobs, update settings, and use Android Architecture Components."));
        itemsMainMenu.add(new ItemsMainMenu("3. Version Control Systems", R.drawable.vcs, "Version control, also known as source control, is the practice of tracking and managing " +
                "changes to software code. Version control systems are software tools that help software teams manage changes to source code over time."));
        itemsMainMenu.add(new ItemsMainMenu("4. Repo hosting Services", R.drawable.repo, "Repository hosting services are third-party web applications that wrap and enhance a version " +
                "control system. You cannot fully utilize a repository hosting service without using an underlying version control system."));
        itemsMainMenu.add(new ItemsMainMenu("5. Build an Application", R.drawable.build_app, "This section describes how to build a simple Android app. First, you learn how to create " +
                "a \"Hello, World!\" project with Android Studio and run it. Then, you create a new interface for the app that takes user input and switches to a new screen in the app to display it. "));
        itemsMainMenu.add(new ItemsMainMenu("6. Writing Robust Apps", R.drawable.robust, "Nowadays, it is going to be hard to build a robust android application, an application that fits " +
                "the user experience, offline first, not buggy, scalable, maintainable and testable application. So, what we are going to do in this section is to offer you some Tips and Tricks " +
                "— according to our experience — to how to build a robust android application from scratch."));
        itemsMainMenu.add(new ItemsMainMenu("7. Keep Learning!", R.drawable.keep_learning, "A person cannot possess all the knowledge about something. So, to keep increasing your knowledge " +
                "and stay up-to-date, keep learning!"));
        itemsMainMenu.add(new ItemsMainMenu("Some Top Android Books", R.drawable.books,"To further help you with your goal of becoming an android developer, we have attached PDFs of some of the " +
                "top books for android development here."));

        mainMenuRecView.setAdapter(adapterMainMenu);
        mainMenuRecView.setLayoutManager(new LinearLayoutManager(this));
        adapterMainMenu.setItemsMainMenu(itemsMainMenu);


    }
}