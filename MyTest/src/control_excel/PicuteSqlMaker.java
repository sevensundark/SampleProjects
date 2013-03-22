package control_excel;

import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PicuteSqlMaker {
	
	private static String FILE_PATH = "D:/sql_maker_for_excel/picute_resource_sql_maker.xlsx";
	
	private static int COL_TYPE = 1;
	
	private static int COL_LANGUAGE = 2;
	
	private static int COL_TITLE = 3;
	
	private static int COL_PRODUCTID = 4;
	
	private static int COL_STYLE = 5;
	
	private static int COL_PRICE = 6;
	
	private static int COL_COMMENT = 9;
	
	private static int COL_ATTENTION = 10;
	
	private static int COL_COUNTRY = 11;
	
	private static int COL_PUBLISH = 12;
	
	private static class ResInfoDto {
		
		public String type;
		
		public String typeTxt;
		
		public String productId;
		
		public String style;
		
		public String styleTxt;
		
		public String price;
		
		public String publishDate;
		
		public List<String> languageList;
		
		public List<String> countryList;
		
		public Map<String, String> titleMap;
		
		public Map<String, String> commentMap;
		
		public Map<String, String> attentionMap;
		
		public void makeSql() {
			product_manager_maker();
			product_region_maker();
			product_info_maker();
			resource_info_maker();
			product_chara_maker();
		}
		
		private void product_manager_maker() {
			final String insert_sql = "insert into product_manager(product_id,keyword,type,style,publish_date,dl_count,push) values";
			String sql = insert_sql + "('" + productId + "','" + typeTxt + "," + styleTxt + "','" + type + "','" + style + "','" + publishDate + "'," + "0," + "null)";
			System.out.println(sql);
		}
		
		private void product_region_maker() {
			final String insert_sql = "insert into product_region(product_id,country_cd,price) values";
			
			String sql = null;
			for (String country : countryList) {
				if (country == null || country.isEmpty()) continue; 
				
				sql = insert_sql + "('" + productId + "','" + country + "'," + price + ")";
				System.out.println(sql);
			}
		}
		
		private void product_info_maker() {
			final String insert_sql = "insert into product_info(product_id,language_cd,title,comment,attention) values";
			
			String sql = null;
			for (String language : languageList) {
				String attention = "null";
				if (attentionMap != null && attentionMap.containsKey(language)) {
					attention = attentionMap.get(language);
				}
				
				sql = insert_sql + "('" + productId + "','" + language + "',N'" + titleMap.get(language) + "',N'" + commentMap.get(language) + "'," + attention + ")";
				System.out.println(sql);
			}
		}
		
		private void resource_info_maker() {
			final String insert_sql = "insert into resource_info(product_id,icon,icon_detail,image) values";
			String sql = insert_sql + "('" + productId + "','" + productId + ".png','" + productId + "_d.png','" + productId + ".zip')";
			System.out.println(sql);
		}
		
		private void product_chara_maker() {
			final String insert_sql = "insert into product_chara(product_id,chara_cd) values";
			// TODO:chara_cd
			String sql = insert_sql + "('" + productId + "','" + "MTI" + "')";
			System.out.println(sql);
		}
	}
	
	
	public static void main(String[] args) {
		getSqlFromExcel();
//		read2007Excel();
	}
	
	private static void getSqlFromExcel() {
		try {
			XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(FILE_PATH));
			XSSFSheet sheet = workBook.getSheet("info");
			
			XSSFRow row = null;
			XSSFCell cell = null;

			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getRow(1).getLastCellNum());
			
			List<ResInfoDto> allInfoList = new ArrayList<ResInfoDto>();
			ResInfoDto resDto = null;
			
			String languageId = null;
			
			for (int r = 2; r <= sheet.getLastRowNum(); r++) {
				row = sheet.getRow(r);
				for (int c = 1; c < row.getLastCellNum(); c++) {
					cell = row.getCell(c);
					if (cell == null) continue;
					
					String value = null;
					if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
						NumberFormat format = NumberFormat.getInstance();
						format.setGroupingUsed(false);
						value = format.format(cell.getNumericCellValue()); 
					} else {
						value = cell.getStringCellValue();
					}

					
					if (strIsEmpty(value)) continue;
					
					if (c == COL_TYPE) {
						if (resDto != null) {
							allInfoList.add(resDto);
						}
						resDto = new ResInfoDto();
						resDto.titleMap = new HashMap<String, String>();
						resDto.commentMap = new HashMap<String, String>();
						resDto.languageList = new ArrayList<String>();
						resDto.countryList = new ArrayList<String>(); 
						resDto.attentionMap =  new HashMap<String, String>();
						resDto.typeTxt = value;
						resDto.type = getType(value);
					} else if (c == COL_LANGUAGE) {
						languageId = getLanguage(value);
						resDto.languageList.add(languageId);
					} else if (c == COL_TITLE) {
						resDto.titleMap.put(languageId, value);;
					} else if (c == COL_PRODUCTID) {
						resDto.productId = value;
					} else if (c == COL_STYLE) {
						resDto.styleTxt = value;
						resDto.style = getStyle(value, resDto.type);
					} else if (c == COL_PRICE) {
						resDto.price = "free".equals(value) ? "0" : value;
					} else if (c == COL_COMMENT) {
						resDto.commentMap.put(languageId, formatComment(value));
					} else if (c == COL_ATTENTION) {
						resDto.attentionMap.put(languageId, formatComment(value));
					} else if (c == COL_COUNTRY) {
						resDto.countryList.add(getLanguage(value));
					} else if (c == COL_PUBLISH) {
						resDto.publishDate = value;
					}
				}
				
				if (r == sheet.getLastRowNum()) {
					allInfoList.add(resDto);
				}
			}
			
			for (ResInfoDto res : allInfoList) {
				res.makeSql();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static boolean strIsEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	private static String getType(String type) {
		type = type.trim();
		
		if ("frame".equals(type)) {
			return "01";
		} else if ("stamp".equals(type)) {
			return "02";
		} else if ("roller".equals(type)) {
			return "03";
		} else if ("label".equals(type)) {
			return "04";
		} else if ("word".equals(type)) {
			return "05";
		} else {
			return type;
		}
	}
	
	private static String getLanguage(String language) {
		language = language.trim();
		
		if ("日本語".equals(language)) {
			return "01";
		} else if ("英語".equals(language)) {
			return "02";
		} else if ("中国語(簡)".equals(language)) {
			return "03";
		} else if ("中国語(繁)".equals(language)) {
			return "04";
		} else if ("韓国語".equals(language)) {
			return "05";
		} else {
			return language;
		}
	}
	
	private static String getStyle(String style, String type) {
		style = style.trim();
		 
		if ("01".equals(type)) {
			if ("photo".equals(style)) {
				return "20";
			} else if ("girly".equals(style)) {
				return "30";
			} else if ("simple".equals(style)) {
				return "40";
			}
		} else if ("02".equals(type)) {
			if ("girly".equals(style)) {
				return "20";
			} else if ("pop".equals(style)) {
				return "30";
			} else if ("twinkle".equals(style)) {
				return "40";
			} else if ("character".equals(style)) {
				return "50";
			}
		} else if ("03".equals(type)) {
			if ("girly".equals(style)) {
				return "20";
			} else if ("pop".equals(style)) {
				return "30";
			} else if ("twinkle".equals(style)) {
				return "40";
			} else if ("character".equals(style)) {
				return "50";
			}
		} else if ("04".equals(type)) {
			if ("tape".equals(style)) {
				return "20";
			} else if ("tag".equals(style)) {
				return "30";
			} else if ("balloon".equals(style)) {
				return "40";
			}
		} else if ("05".equals(type)) {
			return "";
		}
		
		return style;
	}
	
	private static String formatComment(String comment) {
		if (comment.contains("\n")) {
			return comment.replaceAll("\n", "");
		} else {
			return comment;
		}
	}
	
	private static void read2007Excel() {
		try {
			XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(FILE_PATH));
			XSSFSheet sheet = workBook.getSheet("info");
			
			XSSFRow row = null;
			XSSFCell cell = null;

//			for (int r = 1; r <= 31; r++) {
//				row = sheet.getRow(r);
//				for (int c = 1; c <= 9; c++) {
//					cell = row.getCell(c);
//					System.out.print(cell.getStringCellValue() + "        ");
//				}
//				System.out.println();
//			}
			
			row = sheet.getRow(2);
			cell = row.getCell(9);
//			System.out.println(sheet.getLastRowNum());
//			System.out.println(row.getLastCellNum());
			String str = cell.getStringCellValue();
			if (str.contains("\n")) {
				System.out.println("yes");
				str = str.replaceAll("\n", "");
			}
			System.out.println(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void read2003Excel() {
		try {
			HSSFWorkbook workBook = new HSSFWorkbook(new FileInputStream(FILE_PATH));
			HSSFSheet sheet = workBook.getSheet("info");
			
			HSSFRow row = null;
			HSSFCell cell = null;

			for (int r = 1; r <= 33; r++) {
				row = sheet.getRow(r);
				for (int c = 1; c <= 8; c++) {
					cell = row.getCell(c);
					System.out.print(cell.getStringCellValue() + "        ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
