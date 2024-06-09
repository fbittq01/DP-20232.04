package dao.media.factory;
import dao.media.type;

import entity.db.AIMSDB;
import entity.media.CD;
import entity.media.Media;
import entity.media.type.MediaType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class CDFactory extends MediaFactory {
    public CDFactory() {
    }

    @Override
    public Media create(Media media) throws SQLException {
        if(media.getType().equals(MediaType.book.toString())) {
            String sql = "SELECT * FROM "+
                    "aims.CD " +
                    "where Media.id = " + media.getId() + ";";
            Statement stm = AIMSDB.getConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()) {
                // from Book table
                String artist = res.getString("artist");
                String recordLabel = res.getString("recordLabel");
                String musicType = res.getString("musicType");
                Date releasedDate = res.getDate("releasedDate");


                return new CD(media.getId(), media.getTitle(), media.getCategory(), media.getPrice(),
                        media.getQuantity(), media.getType(), artist, recordLabel, musicType, releasedDate);
            } else {
                throw new SQLException();
            }
        }
        return null;
    }
}