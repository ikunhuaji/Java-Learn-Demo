package com.starrysky.cakelesson.db;

import com.starrysky.cakelesson.entity.Cake;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Db {
    public static int cnt = 0;
    public static CopyOnWriteArrayList<Cake> list = new CopyOnWriteArrayList<>();
}
