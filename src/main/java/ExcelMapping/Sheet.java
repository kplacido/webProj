package ExcelMapping;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.*;

public class Sheet {
    ExcelReaderHelper excelReader;
    String planilha;
    List<String> header = new ArrayList<>();

    public Sheet(String path, String planilha){
        excelReader = new ExcelReaderHelper(path);
        this.planilha = planilha;
        mapearColunas();
    }

    private void mapearColunas() {
        int totalColunas = excelReader.returnSheetSize(planilha);
        for(int i = 0;i<totalColunas;i++){
            System.out.println(excelReader.getData(planilha,0,i));
            header.add(excelReader.getData(planilha,0,i));
        }
    }

    public String getData(String column, int row) {
        int coluna = header.indexOf(column);

        return excelReader.getData(planilha,row,coluna);
    }
}
