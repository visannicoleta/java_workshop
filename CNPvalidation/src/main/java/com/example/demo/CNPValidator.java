package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CNPValidator {

	private String cnp;

	public CNPValidator(String cnp) {
		this.cnp = cnp;
	}

	public boolean isCNPValid() {
		return isLengthValid() && isSexValid() && isDateValid() && isMonthValid() && isDateValid() && isCountyValid()
				&& isNNNValid() && isCValid();
	}

	private boolean isLengthValid() {
		return cnp.length() == 13;
	}

	/**
	 * Prima cifră a C.N.P.-ului este: (sex bărbătesc / sex femeiesc)
	 * 
	 * 1 / 2 - născuți între 1 ianuarie 1900 și 31 decembrie 1999 3 / 4 născuți
	 * între 1 ianuarie 1800 și 31 decembrie 1899 5 / 6 - născuți între 1
	 * ianuarie 2000 și 31 decembrie 2099 7 / 8 - pentru persoanele străine
	 * rezidente în România.
	 * 
	 * @return
	 */
	private boolean isSexValid() {
		int sex = Integer.parseInt(cnp.substring(0, 1));

		return sex > 0 && sex < 9 ? true : false;
	}

	/**
	 * AA este un număr format din 2 cifre și reprezintă ultimele 2 cifre din
	 * anul nașterii. O persoană născută în anul 1970 va avea la AA 70. (SAA =
	 * 170, pentru o persoană de sex masculin)
	 * 
	 * Dacă o persoană va avea prima cifră cu una din valorile 7, 8 (rezidenți),
	 * atunci se va considera secolul 20. Ex. SAA = 771, anul nașterii va fi
	 * 1971.
	 * 
	 * 
	 * @return
	 */
	private boolean isDateValid() {
		boolean isDateValid = true;

		int sex = Integer.parseInt(cnp.substring(0, 1));

		int aa = Integer.parseInt(cnp.substring(1, 3));
		int ll = Integer.parseInt(cnp.substring(3, 5));
		int zz = Integer.parseInt(cnp.substring(5, 7));

		String yearPrefix = sex == 3 || sex == 4 ? "18" : sex == 5 || sex == 6 ? "20" : "19";

		StringBuilder sb = new StringBuilder();
		sb.append(yearPrefix);
		sb.append(aa);
		sb.append("-" + ll + "-");
		sb.append(zz);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		Date dateFromCNP = null;

		try {
			dateFromCNP = dateFormat.parse(sb.toString());
			Calendar cal = Calendar.getInstance();
			cal.setLenient(false);
			cal.setTime(dateFromCNP);
			cal.getTime();

		} catch (ParseException e) {
			isDateValid = false;
		}

		return isDateValid && dateFromCNP.before(new Date());
	}

	/**
	 * * LL este un număr format din 2 cifre și reprezintă luna nașterii
	 * persoanei.
	 * 
	 * @return
	 */

	private boolean isMonthValid() {
		int ll = Integer.parseInt(cnp.substring(3, 5));
		return ll > 0 && ll < 13;
	}

	/**
	 * * ZZ reprezintă ziua nașterii în format de 2 cifre. Pentru zilele de la 1
	 * la 9 se adaugă 0 înaintea datei. Spre exemplificare, o persoană născută
	 * în prima zi a lunii va avea codul 01.
	 * 
	 * @return
	 */

	private boolean isDayValid() {
		int zz = Integer.parseInt(cnp.substring(5, 7));
		return zz > 0 && zz < 31;
	}

	/**
	 * JJ este un număr format din două cifre și este reprezentat de codul
	 * județului sau sectorului (în cazul municipiului București) în care s-a
	 * născut persoana ori în care avea domiciliul sau reședința în momentul
	 * acordării C.N.P.-ului.
	 * 
	 * De exemplu, pentru Buzău acest număr este 10. Pentru București, codul
	 * este un număr din intervalul 41 și 46 și reprezintă sectorul în care s-a
	 * născut acea persoană.
	 * 
	 * Codurile județelor sunt în ordinea alfabetică a acestora, cu unele
	 * excepții.
	 */
	private boolean isCountyValid() {
		int jj = Integer.parseInt(cnp.substring(7, 9));
		return (jj > 0 && jj < 47) || jj == 51 || jj == 52;
	}

	/**
	 * NNN este un număr format din 3 cifre din intervalul 001 - 999. Numerele
	 * din acest interval se împart pe județe, birourilor de Evidență a
	 * Populației, astfel încât un anumit număr din acel interval să fie alocat
	 * unei singure persoane într-o anumită zi.
	 */

	private boolean isNNNValid() {
		int nnn = Integer.parseInt(cnp.substring(9, 12));

		return nnn > 0 && nnn <= 999;
	}

	/**
	 * C este cifră de control (un cod autodetector) aflată în relație cu toate
	 * celelate 12 cifre ale C.N.P.-ului. Cifra de control este calculată după
	 * cum urmează: fiecare cifră din C.N.P. este înmulțită cu cifra de pe
	 * aceeași poziție din numărul 279146358279; rezultatele sunt însumate, iar
	 * rezultatul final este împărțit cu rest la 11. Dacă restul este 10, atunci
	 * cifra de control este 1, altfel cifra de control este egală cu restul.
	 */

	private boolean isCValid() {
		int c = Integer.parseInt(cnp.substring(12, 13));
		final String no = "279146358279";
		int calculatedC = 0;
		long sum = 0;
		for (int i = 0; i < no.length(); i++) {
			sum += Integer.parseInt(cnp.substring(i, i + 1)) * Integer.parseInt(no.substring(i, i + 1));
		}

		int rest = (int) (sum % 11);
		calculatedC = rest == 10 ? 1 : rest;

		return calculatedC == c;
	}
}
