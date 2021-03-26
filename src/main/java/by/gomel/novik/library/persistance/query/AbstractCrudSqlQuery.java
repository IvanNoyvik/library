//package by.gomel.library.query;
//
//import by.gomel.novik.speed.Speed;
//import by.gomel.novik.speed.SpeedList;
//
//import java.io.*;
//import java.lang.reflect.Field;
//
//public class AbstractCrudSqlQuery implements CrudSqlQuery {
//
//    private final String FIND_BY_ID_SQL_QUERY;
//    private final String FIND_ALL_SQL_QUERY;
//    private final String SAVE_SQL_QUERY;
//    private final String UPDATE_SQL_QUERY;
//    private final String DELETE_BY_ID_SQL_QUERY;
//
//    public AbstractCrudSqlQuery(String filePath) {
//
//
//    }
//
//    public void init(String filePath) {
//
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource(filePath).getFile());
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//
//            String line = reader.readLine();
//            String[] fieldNames = getFieldsName();
//
//            while (line != null) {
//
//                String[] splitLine = line.split("=");
//
//
//
//                line = reader.readLine();
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл не найден");
//        } catch (IOException e) {
//            System.out.println("Ошибка чтения файла");
//        }
//
//    }
//
//    private String[] getFieldsName(){
//
//        Field[] fields = this.getClass().getDeclaredFields();
//        String[] result = new String[fields.length];
//
//        for (int i = 0; i < fields.length; i++) {
//            result[i] = fields[i].getName();
//        }
//
//        return result;
//    }
//
//    public String findByIdSqlQuery(){
//        return FIND_BY_ID_SQL_QUERY;
//    };
//    public String findAllSqlQuery(){
//        return FIND_ALL_SQL_QUERY;
//    };
//    public String saveSqlQuery(){
//        return SAVE_SQL_QUERY;
//    };
//    public String updateSqlQuery(){
//        return UPDATE_SQL_QUERY;
//    };
//    public String deleteByIdSqlQuery(){
//        return DELETE_BY_ID_SQL_QUERY;
//    };
//
//}
