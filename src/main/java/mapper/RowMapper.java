package mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T mapRow(ResultSet rs);

    class AbstractModel {
        Long id;
        String createDate;
        Integer status;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }
}
