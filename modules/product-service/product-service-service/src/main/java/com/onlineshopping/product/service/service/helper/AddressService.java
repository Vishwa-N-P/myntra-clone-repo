package com.onlineshopping.product.service.service.helper;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.service.constats.ShoppingContants;

import java.util.ArrayList;
import java.util.List;

public class AddressService {

    public static Address addUserAddress(long userId, String userName, String phone, String userAddress, int regionId, String city, String state) {

        Address address = AddressLocalServiceUtil.createAddress(CounterLocalServiceUtil.increment());
        if (userId > 0) {
            address.setUserId(userId);
        }
        if (userName != null) {
            address.setUserName(userName);
        }
        if (phone != null) {
            address.setStreet1(phone);
        }
        if (userAddress != null) {
            address.setStreet2(userAddress);
        }
        if (regionId > 0) {
            address.setRegionId(regionId);
        }
        if (city != null) {
            address.setCity(city);
        }
        if (state != null) {
            address.setStreet3(state);
        }
        address = AddressLocalServiceUtil.addAddress(address);
        return address;
    }

    public Address getUserAddress(long addressId) {
        Address address = null;
        try {
            address = AddressLocalServiceUtil.getAddress(addressId);
        } catch (PortalException e) {
            _log.error(e.getMessage());
        }
        return address;
    }

    public static Address addOrUpdateAddress(long addressId, long userId, String userName, String phone, String userAddress, int regionId, String city, String state) {
        Address address = AddressLocalServiceUtil.fetchAddress(addressId);
        if (addressId < 0 || addressId > 0 && Validator.isNull(address)) {
            _log.error("Invalid address Id");
            return null;
        }

        if(addressId == 0L) {
            address = AddressLocalServiceUtil.createAddress(CounterLocalServiceUtil.increment());
        }

        if (userId > 0) {
            address.setUserId(userId);
        }
        if (userName != null) {
            address.setUserName(userName);
        }
        if (phone != null) {
            address.setStreet1(phone);
        }
        if (userAddress != null) {
            address.setStreet2(userAddress);
        }
        if (regionId > 0) {
            address.setRegionId(regionId);
        }
        if (city != null) {
            address.setCity(city);
        }
        if (state != null) {
            address.setStreet3(state);
        }
        address = AddressLocalServiceUtil.updateAddress(address);
        return address;
    }

    public static List<Address> getAddressByUserId(long userId) {
        List<Address> addressList;
        DynamicQuery dynamicQuery = AddressLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(PropertyFactoryUtil.forName(ShoppingContants.USER_ID).eq(userId));
        addressList = AddressLocalServiceUtil.dynamicQuery(dynamicQuery);
        return addressList;
    }

    public static Address deleteUserAddress(long addressId) {
        try {
            return AddressLocalServiceUtil.deleteAddress(addressId);
        } catch (PortalException e) {
            _log.error(e.getMessage());
        }
        return null;
    }

    public static final Log _log = LogFactoryUtil.getLog(AddressService.class);

}
