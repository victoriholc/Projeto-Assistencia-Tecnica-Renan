package br.com.assistenciaTecnica.generic.dao;

import java.util.List;

public interface IDAO<Entity> 
{
        public void insert(Entity object);
        public void refresh(Entity object);
        public void remove(Entity object);
        public Entity queryById(Integer key);
        public List<Entity> seeAll();
}
