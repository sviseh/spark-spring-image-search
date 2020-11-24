package com.ebayai.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;


@Controller
public class IndexController {
	@RequestMapping(value="/itm/{itemId}", method = RequestMethod.GET)
	public String itemSearch() throws IOException {
		return "item";
	}
	/***********************************
	 *
	 **********************************/
	@RequestMapping(value={"/", "/cat/{catId}", "/cat"}, method = RequestMethod.GET)
	public String catSearch() {
		return "category";
	}
}
