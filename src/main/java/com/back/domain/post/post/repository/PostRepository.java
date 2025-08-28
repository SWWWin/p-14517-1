package com.back.domain.post.post.repository;

import com.back.domain.post.post.dto.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostRepository {

    @Select("""
    <script>
    SELECT * 
    FROM post
    </script>
    """)
    List<Post> findAll();

    @Select("""
    <script>
    SELECT * 
    FROM post
        <if test="orderBy != null and orderBy != ''">
            ORDER BY
            <choose>
                <when test="orderBy == 'title'">title</when>
                <when test="orderBy == 'createDate'">createDate</when>
                <when test="orderBy == 'modifyDate'">modifyDate</when>
            </choose>
        </if>
        <if test="orderByDirection != null and orderByDirection.toLowerCase() == 'desc'">
            DESC
        </if>
    </script>
    """)
    List<Post> findAllOrdered(
            @Param("orderBy") String orderBy,
            @Param("orderByDirection") String orderByDirection
    );

    @Select("""
            <script>
            SELECT *
                       FROM post
                       WHERE id = #{id}
            </script>
            """)
    Post findById(int id);

    @Insert("""
            <script>
            INSERT INTO post 
            SET createDate = NOW(),
            modifyDate = NOW(),
            title = #{title},
            content = #{content}
            </script>
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Post post);


    @Insert("""
            <script>
            INSERT INTO post 
            SET createDate = NOW(),
            modifyDate = NOW(),
            title = #{title},
            content = #{content}
            </script>
            """)
    int createV2(String title, String content);

    @Select("""
            SELECT LAST_INSERT_ID()
            """)
    public int getLastInsertId();

    @Delete("""
                DELETE FROM post
                WHERE id = #{id}
            """)
    void deleteById(int id);

    @Update("""
            <script>
            UPDATE post
            <set>
                modifyDate = NOW(),
                <if test="title != null and title != ''">
                    title = #{title},
                </if>
                <if test="content != null and content != ''">
                    content = #{content},
                </if>
            </set>
            <where>
                <if test="id != null and id > 0">
                    id = #{id}
                </if>
            </where>
                  </script>
            """)
    void update(@Param("id") Integer id,
                @Param("title") String title,
                @Param("content") String content);


    @Select("""
            <script>
            SELECT *
            FROM post
            WHERE
              <choose>
                <when test="column == 'title'">
                  title LIKE CONCAT('%', #{keyword}, '%')
                </when>
                <when test="column == 'content'">
                  content LIKE CONCAT('%', #{keyword}, '%')
                </when>
                <otherwise>
                    title LIKE CONCAT('%', #{keyword}, '%')
                    OR
                    content LIKE CONCAT('%', #{keyword}, '%')
                </otherwise>
              </choose>
            </script>
            """)
    List<Post> search(@Param("column") String column, @Param("keyword") String keyword);

    @Delete("""
            <script>
            DELETE FROM post
            where id IN
            <foreach collection="ids" item="id" open="(" separator="," close=")">
            #{id}
                </foreach>
            </script>
            """)
    int deleteByIds(@Param("ids") List<Object> ids);


}
