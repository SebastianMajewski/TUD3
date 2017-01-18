package repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.Part;
import domain.Phone;

import org.junit.After;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import service.PartManager;
import service.PhoneManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })

public class PhoneManagerTest 
{
	
    @Autowired
    PhoneManager phoneManager;
    @Autowired
    PartManager partManager;
        
    @After
    public void clear() 
    {
        phoneManager.clear();
        partManager.clear();
    }
        
    @Before
    public void add() 
    {
        Phone phone = new Phone();
        phone.setModel("Microsoft Lumia 535");
        phone.setPrice(500);
        phone.setMegaPixels(5);
        phone.setSold(false);
        phoneManager.add(phone);
    }
        
    @Test
    public void addPhone()
    {
        Phone phone = new Phone();
        phone.setModel("Lumia 700");
        phone.setPrice(300);
        phone.setMegaPixels(2);
        phone.setSold(false);
        phoneManager.add(phone);

        assertTrue(phoneManager.getPhoneByModel("Lumia 700").size() == 1);
    }
        
    @Test 
    public void phoneEdit() 
    {
        Phone phone = phoneManager.getPhoneByModel("Microsoft Lumia 535").get(0);
        phone.setModel("Lumia 300");
        phone.setSold(true);
        phoneManager.add(phone);
        
        Phone _phone = phoneManager.getPhoneByModel("Lumia 300").get(0);
        assertEquals(_phone.getModel(), "Lumia 300");
        assertEquals(_phone.getPrice(), 500, 0.01);
        assertEquals(_phone.getMegaPixels(), 5);
        assertEquals(_phone.getSold(), true);
    }
        
    @Test
    public void phoneRemove() 
    {
    	Phone phone = new Phone();
    	phone.setModel("Lumia 750");
        phone.setPrice(680);
        phone.setMegaPixels(12);
        phone.setSold(false);
    	phoneManager.add(phone);
            
        Phone _phone = phoneManager.getPhoneByModel("Lumia 750").get(0);
        phoneManager.remove(_phone);
            
        List<Phone> list = (List<Phone>) phoneManager.getAll();
        Phone __phone = list.get(0);
            
        assertEquals(__phone.getModel(), "Microsoft Lumia 535");
        assertEquals(__phone.getPrice(), 500, 0.01);
        assertEquals(__phone.getMegaPixels(), 5);
        assertEquals(__phone.getSold(), false);
    }
        
        
    @Test
    public void phoneGetByModel() 
    {
        Phone phone = phoneManager.getPhoneByModel("Microsoft Lumia 535").get(0);

        assertEquals(phone.getModel(), "Microsoft Lumia 535");
        assertEquals(phone.getPrice(), 500, 0.01);
        assertEquals(phone.getMegaPixels(), 5);
        assertEquals(phone.getSold(), false);          
    }
        
        
    @Test
    public void addPart() 
    {
        Part part = new Part();
        part.setName("Screen");
        part.setPrice(120);
        partManager.add(part);
        
        Phone phone = phoneManager.getPhoneByModel("Microsoft Lumia 535").get(0);
        phone.addPart(part);
        phoneManager.add(phone);
        
        Phone _phone = phoneManager.getPhoneByModel("Microsoft Lumia 535").get(0);
        
        assertTrue(_phone.getParts().size() == 1);
    }
    
    @Test
    public void findByFirstLetter() 
    {
        Phone phone = new Phone();
        phone.setModel("Lumia 700");
        phone.setPrice(300);
        phone.setMegaPixels(2);
        phone.setSold(false);
        phoneManager.add(phone);
        
        List<Phone> phones = phoneManager.getPhonesStartsWith("L");
        
        assertTrue(phones.size() == 1);
    }
    
    @Test
    public void removePartsByName() 
    {
        Part part = new Part();
        part.setName("Screen");
        part.setPrice(120);
        partManager.add(part);
        
        Part _part = new Part();
        _part.setName("Connector");
        _part.setPrice(12);
        partManager.add(_part);
        
        Part __part = new Part();
        __part.setName("Connector");
        __part.setPrice(16);
        partManager.add(__part);
        
        Phone phone = phoneManager.getPhoneByModel("Microsoft Lumia 535").get(0);
        phone.addPart(part);
        phone.addPart(_part);
        phone.addPart(__part);
        phoneManager.add(phone);
        
        int i = phoneManager.removePartsByName(phone, "Connector");
        
        Phone _phone = phoneManager.getPhoneByModel("Microsoft Lumia 535").get(0);
        assertTrue(_phone.getParts().size() == 1); 
    }

}
