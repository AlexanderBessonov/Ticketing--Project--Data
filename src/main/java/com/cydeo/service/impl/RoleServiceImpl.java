package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.repository.RoleRepository;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        //Controller called me and requestiond so it can show in the drop-down in the UI
        //I need to make a call to DB  and get all the roles from table
        //Go to repository and find a service which gives me the roles from DB
        //how i will call any service here?
      List <Role> roleList =roleRepository.findAll();
          //i Have Role entities from DB
        //I need to converter those Role entities to DTOs
        //I need to use Modelmapper
        //I alredy created


        //Some comments to explain what it does.
        return roleList.stream()
                .map(role->mapperUtil.convert(role, new RoleDTO()))
                .collect(Collectors.toList());

//        return roleList.stream()
//                .map(role->mapperUtil.convert(role, new RoleDTO.class))
//                .collect(Collectors.toList());

//        return roleList.stream()
//                .map(roleMapper::convertToDto)
//                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {
        return  roleMapper.convertToDto(roleRepository.findById(id).get());

    }
}
