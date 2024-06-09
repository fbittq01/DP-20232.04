package dao.media.factory;
import dao.media.type;

import entity.db.AIMSDB;
import entity.media.Book;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AudioBookFactory extends MediaFactory {
    public AudioBookFactory() {
    }

    @Override
    public Media create(Media media) throws SQLException {
        if(media.getType().equals(MediaType.book.toString())) {
            String sql = "SELECT * FROM "+
                    "aims.AudioBook " +
                    "where AudioBook.id = " + media.getId() + ";";
            Statement stm = AIMSDB.getConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()) {
                // from Book table
                String author = res.getString("author");
                String format = res.getString("format");
                String language = res.getString("language");
                Date accent = res.getDate("accent");
                int lengthInMinutes = res.getInt("lengthInMinutes");

                return new Book(media.getId(), media.getTitle(), media.getCategory(), media.getPrice(),
                        media.getQuantity(), media.getType(), author, format, language, accent, lengthInMinutes);
            } else {
                throw new SQLException();
            }
        }
        return null;
    }
}