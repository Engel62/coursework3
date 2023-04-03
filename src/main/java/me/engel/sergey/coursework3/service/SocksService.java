package me.engel.sergey.coursework3.service;

import me.engel.sergey.coursework3.models.Color;
import me.engel.sergey.coursework3.models.Size;
import me.engel.sergey.coursework3.models.Socks;

public interface SocksService {

    Socks addSocks(Socks socks, long quantity);

    Socks editSocks(Socks socks, long quantity);

    long getSocksNumByParam(Color color, Size size, int cottonMin, int cottonMax);

    boolean deleteSocks(Socks socks, long quantity);
}
