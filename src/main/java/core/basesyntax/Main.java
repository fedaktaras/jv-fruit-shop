package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderCsv;
import core.basesyntax.service.impl.WriterCsv;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String WRITE_FILE_PATH = "src/files/fruits_report.csv";
    private static final String READ_FILE_PATH = "src/files/fruits.csv";

    public static void main(String[] args) {
        Reader reader = new ReaderCsv(READ_FILE_PATH);
        List<String> lines = reader.readData();
        Parser parser = new ParserImpl();
        List<Operation> parsedData = parser.parseToOperations(lines);
        OperationStrategy operationStrategy = new OperationStrategy();
        for (var pd : parsedData) {
            operationStrategy.processData(pd);
        }
        Writer writer = new WriterCsv(WRITE_FILE_PATH);
        writer.writeData();
    }
}
