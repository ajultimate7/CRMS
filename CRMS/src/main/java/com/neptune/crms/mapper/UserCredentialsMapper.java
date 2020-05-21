package com.neptune.crms.mapper;

import org.mapstruct.Mapper;

import com.neptune.crms.dto.UserCredentialsDTO;
import com.neptune.crms.entity.UserCredentialsEntity;
import com.neptune.crms.indto.UserCredentialsInDTO;

@Mapper
public interface UserCredentialsMapper {

	UserCredentialsInDTO entityToInDTO(UserCredentialsEntity userCredentials);

	UserCredentialsEntity inDTOToEntity(UserCredentialsInDTO userCredentials);

	UserCredentialsDTO entityToDTO(UserCredentialsEntity userCredentials);

}
