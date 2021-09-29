package br.eti.carloslima.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	/*
	 * Class para decodifica o texto da busca vindo da url
	 */
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
