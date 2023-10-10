package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    ItemRepo itemRepo;

    @Autowired
    ModelMapper mapper;
    @Override
    public void saveItem(ItemDTO dto) {
        Item item = mapper.map (dto, Item.class);
        itemRepo.save (item);
    }

    @Override
    public void deleteItem(String id) {
        itemRepo.deleteById (id);
    }

    @Override
    public List<ItemDTO> getAllItem() {
        List<Item> all = itemRepo.findAll ();
        return mapper.map (all,new TypeToken<List<CustomerDTO>> (){}.getType ());
    }

    @Override
    public ItemDTO findItem(String id) {
        Item item = itemRepo.findById (id).get ();
        return mapper.map (item, ItemDTO.class);
    }

    @Override
    public void updateItem(ItemDTO c) {
        Item item = mapper.map (c, Item.class);
        itemRepo.save (item);
    }
}
