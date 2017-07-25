/*
 * Copyright (c) 2015 LingoChamp Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liulishuo.filedownloader.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.liulishuo.filedownloader.demo.db.User;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

import java.util.List;
import java.util.UUID;

/**
 * Created by Jacksgong on 12/21/15.
 */
public class DbTaskTestActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        FlowManager.init(this);

        text = (TextView) findViewById(R.id.text);
        User user = new User();
        user.id = UUID.randomUUID();
        user.name = "Andrew Grosner";
        user.age = 27;
        ModelAdapter<User> adapter = FlowManager.getModelAdapter(User.class);
        adapter.save(user);
        List<User> contentBeanList = SQLite.select().
                from(User.class)
                .queryList();
        text.setText(contentBeanList.toString());
    }


}
