package com.dropdownajex.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.MarkedYAMLException;

import com.dropdownajex.dto.UserDto;
import com.dropdownajex.entity.UserEntity;
import com.dropdownajex.exception.MyException;
import com.dropdownajex.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<UserDto> getAllUser() {

		List<UserEntity> usr = this.userRepo.findAll();
		List<UserDto> usrDto = usr.stream().map(x -> entitytoDto(x)).collect(Collectors.toList());
		return usrDto;
	}

	@Override
	public UserDto getUser(int id) throws MyException  {

		UserEntity userEntity = userRepo.findById(id).orElseThrow(() -> new MyException("value not found", "please check",HttpStatus.BAD_GATEWAY));
		return entitytoDto(userEntity);

	}

	@Override
	public List<UserEntity> saveUser(List<UserDto> u) {

		List<UserEntity> usr = u.stream().map(a -> dtoToEntity(a)).collect(Collectors.toList());
		// UserEntity usr = dtoToEntity(u);
		userRepo.saveAll(usr);

		return usr;

	}

	@Override
	public UserEntity saveUsers(UserDto u){

		// List<UserEntity> usr =
		// u.stream().map(a->dtoToEntity(a)).collect(Collectors.toList());
		
		if(u.equals(null) || u == null)
			
		{
			throw new MyException("value is empty", "please check for it", HttpStatus.BAD_REQUEST);
		}
		UserEntity usr = dtoToEntity(u);
		userRepo.save(usr);

		return usr;

	}

	@Override
	public UserDto updateUser(UserDto u, int id) {

		Optional<UserEntity> usrOptional = userRepo.findById(id);

		UserEntity usr = usrOptional.get();

		usr.setName(u.getName());
		usr.setUsername(u.getUsername());
		usr.setPassword(u.getPassword());
		usr.setAbout(u.getPassword());

		return entitytoDto(userRepo.save(usr));

	}

	@Override
	public UserDto deleteUser(int id) {

		Optional<UserEntity> userEntityOptional = userRepo.findById(id);

		UserEntity userEntity = userEntityOptional.get();
		userRepo.delete(userEntity);

		return entitytoDto(userEntity);
	}

	public UserEntity dtoToEntity(UserDto userDto) {
		UserEntity user = modelMapper.map(userDto, UserEntity.class);
//		user.setName(userDto.getName());
//		user.setAbout(userDto.getAbout());
//		user.setUsername(userDto.getUsername());
//		user.setPassword(userDto.getPassword());

		return user;
	}

	public UserDto entitytoDto(UserEntity useEntity) {
		UserDto userDto = modelMapper.map(useEntity, UserDto.class);
//		userDto.setName(useEntity.getName());
//		userDto.setAbout(useEntity.getAbout());
//		userDto.setUsername(useEntity.getUsername());
//		userDto.setPassword(useEntity.getPassword());

		return userDto;
	}

}
