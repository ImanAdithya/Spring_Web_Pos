package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
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

    }

    @Override
    public List<ItemDTO> getAllItem() {
        return null;
    }

    @Override
    public ItemDTO findItem(String id) {
        return null;
    }

    @Override
    public void updateItem(ItemDTO c) {

    }
}
