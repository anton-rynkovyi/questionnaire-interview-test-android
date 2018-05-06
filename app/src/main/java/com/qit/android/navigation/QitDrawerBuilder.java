package com.qit.android.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.qit.R;
import com.qit.android.activity.AuthorizationActivity;
import com.qit.android.activity.RegistrationActivity;
import com.qit.android.constants.DrawerItemTags;
import com.qit.android.constants.SharedPreferencesTags;
import com.qit.android.models.quiz.Interview;
import com.qit.android.rest.utils.FirebaseCountObjInList;

public class QitDrawerBuilder implements Drawer.OnDrawerItemClickListener {

    private DrawerBuilder drawerBuilder;
    private Activity activity;
    private Toolbar toolbar;
    private SharedPreferences sharedPreferences;


    private SecondaryDrawerItem itemQuestionnaire;
    private SecondaryDrawerItem itemInterview;
    private SecondaryDrawerItem itemChat;
    private SecondaryDrawerItem editProfile;
    private SecondaryDrawerItem itemLogout;

    public QitDrawerBuilder() {
        this.drawerBuilder = new DrawerBuilder();
    }

    public QitDrawerBuilder setActivity(Activity activity) {
        this.activity = activity;
        drawerBuilder.withActivity(activity);
        return this;
    }

    public QitDrawerBuilder setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
        drawerBuilder.withToolbar(toolbar);
        return this;
    }

    public Drawer build(Activity activity) {
        setActivity(activity);
        itemQuestionnaire = new SecondaryDrawerItem().withTag(DrawerItemTags.QUEST_TAB).withName(R.string.Questionnaires);
        itemInterview = new SecondaryDrawerItem().withTag(DrawerItemTags.INTER_TAB).withName(R.string.Interviews);
        itemChat = new SecondaryDrawerItem().withTag(DrawerItemTags.CHAT_TAG).withName(R.string.Room_Chat);
        editProfile = new SecondaryDrawerItem().withTag(DrawerItemTags.PROFILE_TAG).withName(R.string.edit_profile);
        itemLogout = new SecondaryDrawerItem().withTag(DrawerItemTags.LOGOUT_TAG).withName(R.string.logout);

        FirebaseCountObjInList firebaseCountObjInList = new FirebaseCountObjInList(itemQuestionnaire, itemInterview);
        firebaseCountObjInList.getIntOfElems();

        AccountHeader accountHeaderBuilder = new QitAccountHeaderBuilder().setActivity(activity).build();

        return drawerBuilder
                .addDrawerItems(
                        itemQuestionnaire,
                        itemInterview,
                        itemChat,
                        editProfile,
                        itemLogout
                )
                .withOnDrawerItemClickListener(this)
                .withAccountHeader(accountHeaderBuilder)
                .build();
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
        switch (String.valueOf(drawerItem.getTag())) {
            case DrawerItemTags.QUEST_TAB:
                //Toast.makeText(view.getContext(), "Questionnaires", Toast.LENGTH_SHORT).show();
                break;
            case DrawerItemTags.INTER_TAB:
                //Toast.makeText(view.getContext(), "Interviews", Toast.LENGTH_SHORT).show();
                break;
            case DrawerItemTags.CHAT_TAG:
                //Toast.makeText(view.getContext(), "Events", Toast.LENGTH_SHORT).show();
                break;
            case DrawerItemTags.PROFILE_TAG:
                Intent intent = new Intent(activity.getApplicationContext(), RegistrationActivity.class);
                intent.putExtra("isRegistrationCHangedFlag", true);

                activity.getApplicationContext().startActivity(intent);

                //Toast.makeText(view.getContext(), "Events", Toast.LENGTH_SHORT).show();
                break;
            case DrawerItemTags.LOGOUT_TAG:
                logout();
                break;
        }
        return false;
    }


    private void logout() {
        if (activity != null) {
            sharedPreferences = activity.getSharedPreferences(AuthorizationActivity.class.getName(), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(SharedPreferencesTags.IS_AUTHORIZE, false);
            editor.commit();
            activity.onBackPressed();
        }
    }
}
