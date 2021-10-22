package com.rodrigues.nunes.vitor.utils;

import com.rodrigues.nunes.vitor.dto.PhoneDTO;
import com.rodrigues.nunes.vitor.entity.Phone;
import com.rodrigues.nunes.vitor.enums.PhoneType;

public class PhoneUtils {

	private static final String PHONE_NUMBER = "12-4567890123";
	private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
	private static final Long PHONE_ID = 1L;

	public static PhoneDTO createFakeDTO() {
		return PhoneDTO.builder().number(PHONE_NUMBER).type(PHONE_TYPE).id(PHONE_ID).build();
	}

	public static Phone createFakeEntity() {
		return Phone.builder().number(PHONE_NUMBER).type(PHONE_TYPE).id(PHONE_ID).build();

	}
}
