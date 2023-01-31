package edu.wpi.FlashyFrogs;

import edu.wpi.FlashyFrogs.ORM.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.Instant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

  static final StandardServiceRegistry registry =
      new StandardServiceRegistryBuilder()
          .configure("./edu/wpi/FlashyFrogs/hibernate.cfg.xml") // Load settings
          .build();

  public static SessionFactory factory =
      new MetadataSources(registry).buildMetadata().buildSessionFactory();

  public static void main(String[] args) throws FileNotFoundException {
    File nodeFile = new File("src/main/resources/edu/wpi/FlashyFrogs/CSVFiles/L1Nodes.csv");
    File edgeFile = new File("src/main/resources/edu/wpi/FlashyFrogs/CSVFiles/L1Edges.csv");
    File moveFile = new File("src/main/resources/edu/wpi/FlashyFrogs/CSVFiles/move.csv");
    File locationFile =
        new File("src/main/resources/edu/wpi/FlashyFrogs/CSVFiles/locationName.csv");

    CSVParser.readFiles(nodeFile, edgeFile, locationFile, moveFile);

    Fapp.launch(Fapp.class, args);
    factory.close();

    // App.launch(App.class, args);

  }
}
