package com.data.dynamic;

import java.util.Locale;

import com.enums.Country;

import static com.config.ConfigurationManager.configuration;

import net.datafaker.Faker;

public class FakerDataFactory {

private static final Faker faker = new Faker(new Locale(configuration().faker()));

	private FakerDataFactory() {

	}

	public static String getCompanyName() {
		return faker.company().name().replaceAll("[^a-zA-Z ]", "");
	}

	public static String getCompanyNameWithoutSpace() {
		return faker.company().name().replaceAll("[^a-zA-Z ]", "").replaceAll("[\\s]", "");
	}
	public static String getUrl() {
		return faker.company().url();
	}

	public static String getAddress() {
		return faker.address().streetAddress();
	}

	public static String getFullAddress() {return faker.address().fullAddress();}

	public static String getCity() {
		return faker.address().city();
	}

	public static String getCountry() {
		return Country.getRandom().get().toString();
	}

	public static String getFirstName() {
		return faker.name().firstName().replaceAll("[^a-zA-Z ]", "");
	}

	public static String getMiddleName() {
		return faker.name().nameWithMiddle();
	}

	public static String getLastName() {
		return faker.name().lastName().replaceAll("[^a-zA-Z ]", "");
	}
	
	public static String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public static String getContactNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public static String getBankAccountNumber() {
		return ""+faker.number().randomNumber(10, false);
	}

	public static String getAlphanumeric() {
		return faker.number().randomNumber(6,false)+"lkjhhh";
	}

	public static String get12DigitsBankAccountNumber() {
		return ""+faker.number().randomNumber(12, false);
	}

	public static String getFTPFolderAcronym() {
		return ""+faker.number().randomNumber(4, false);
	}
	public static String getTaxNumber() {
		return ""+faker.number().randomNumber(7, false);
	}

	public static String getPostalCode() {
		return ""+faker.number().randomNumber(5, false);
	}
	
	public static String getDateFormatting(){
		return faker.options().option("MM/DD/YYYY","DD/MM/YYYY","YYYY-MM-DD");
	}
	
	public static String getTimeFormatting(){
		return faker.options().option("12-hour","24-hour");
	}

}
