package me.engel.sergey.coursework3.service.impl;

import me.engel.sergey.coursework3.models.Color;
import me.engel.sergey.coursework3.models.Size;
import me.engel.sergey.coursework3.models.Socks;
import me.engel.sergey.coursework3.service.SocksService;
import me.engel.sergey.coursework3.service.SocksFilesService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
@Service
public class SocksServiceImpl implements SocksService {
    private final SocksFilesService socksFilesService;

    private static final Map<Socks, Long> socksMap = new HashMap<>();

    public SocksServiceImpl(SocksFilesService socksFilesService) {
        this.socksFilesService = socksFilesService;
    }


    @PostConstruct
    private void init() {
        try {
            socksFilesService.readFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Socks addSocks(Socks socks, long quantity) {
        return null;
    }

    @Override
    public Socks editSocks(Socks socks, long quantity) {
        return null;
    }

    @Override
    public long getSocksNumByParam(Color color, Size size, int cottonMin, int cottonMax) {
        return 0;
    }

    @Override
    public boolean deleteSocks(Socks socks, long quantity) {
        return false;
    }
}
