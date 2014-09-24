/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.dao.SettingDao;
import cs544.letmegiveexam.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Arjun
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SettingService {
    @Autowired
    SettingDao settingDao;
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateSetting(Setting setting) {
        settingDao.update(setting);
    }
 
    @Transactional(propagation = Propagation.REQUIRED)
    public Setting getSetting() {
        long Id=1;
        return (Setting) settingDao.get(Id);
    }    
}
