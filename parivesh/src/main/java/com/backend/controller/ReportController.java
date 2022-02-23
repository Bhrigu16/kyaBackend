package com.backend.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.backend.dto.Clearance;
import com.backend.dto.Toposheet;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.layout.font.FontProvider;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/report")
public class ReportController {

	
	public void newActivity() throws IOException {
		//String html = parseThymeleafTemplate();
		//generatePdfFromHtml(html);

	}

	public void generatePdfFromHtml(String html) throws IOException {
		String outputFolder = "C:\\Users\\JS494ET\\Rahul" + File.separator + "thymeleaf.pdf";
		OutputStream outputStream = new FileOutputStream(outputFolder);
		ConverterProperties properties = new ConverterProperties();
	    FontProvider fontProvider = new DefaultFontProvider();
	    fontProvider.addFont("src/main/resources/static/NotoSans-Regular.ttf");
	    fontProvider.addFont("src/main/resources/static/Sakal_Bharati_Normal_Ship.ttf");
	    fontProvider.addStandardPdfFonts();
	    fontProvider.addSystemFonts(); //for fallback
	    properties.setFontProvider(fontProvider);
	    properties.setCharset(StandardCharsets.UTF_8.toString());
		HtmlConverter.convertToPdf(html, outputStream, properties);
		outputStream.close();
	}

	/*private String parseThymeleafTemplate() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCharacterEncoding("UTF-8");
		
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		List<Toposheet> sheets = new ArrayList<>();
		List<Clearance> clearances = new ArrayList<>();
		Clearance clearance1 = new Clearance();
		clearance1.setId(1);
		clearance1.setApplicabilty("Yes");
		clearance1.setApproval("Environment Clearance");
		clearance1.setRemarks("Mining is prohibited");
		Clearance clearance2 = new Clearance();
		clearance2.setId(2);
		clearance2.setApplicabilty("No");
		clearance2.setApproval("Forest Clearance");
		clearance2.setRemarks("Forest is prohibited");
		Clearance clearance3 = new Clearance();
		clearance2.setId(3);
		clearance2.setApplicabilty("Yes");
		clearance2.setApproval("Wildlife Clearance");
		clearance2.setRemarks("if any");
		Clearance clearance4 = new Clearance();
		clearance2.setId(4);
		clearance2.setApplicabilty("No");
		clearance2.setApproval("Coastal Region Clearance");
		clearance2.setRemarks("NA");
		clearances.add(clearance1);
		clearances.add(clearance2);
		clearances.add(clearance3);
		clearances.add(clearance4);
		Toposheet obj = new Toposheet();
		obj.setState("Rajasthan");
		obj.setDistrict("Jaipur");
		obj.setVillage("Nahargarh");
		obj.setToposheetNo("39L/12");
		sheets.add(obj);
		Context context = new Context();
		context.setVariable("sheets", sheets);
		context.setVariable("clearances", clearances);

		return templateEngine.process("Report", context);
	}*/

}
