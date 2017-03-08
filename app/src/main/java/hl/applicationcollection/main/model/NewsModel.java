package hl.applicationcollection.main.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by huanglin on 2017/3/5.
 * 邮箱：1871767675@qq.com
 */

public class NewsModel implements Parcelable{
    private int id;
    private String name;
    private String summary;
    private String thumbnail;
    private String image;
    private int timestamp;
    private List<NewsModel.DataBean> data;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public List<NewsModel.DataBean> getData() {
        return this.data;
    }

    public void setData(List<NewsModel.DataBean> data) {
        this.data = data;
    }

    protected NewsModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        summary = in.readString();
        thumbnail = in.readString();
        image = in.readString();
        timestamp = in.readInt();
    }

    public static final Creator<NewsModel> CREATOR = new Creator<NewsModel>() {
        @Override
        public NewsModel createFromParcel(Parcel in) {
            return new NewsModel(in);
        }

        @Override
        public NewsModel[] newArray(int size) {
            return new NewsModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(summary);
        parcel.writeString(thumbnail);
        parcel.writeString(image);
        parcel.writeInt(timestamp);
    }

    public static class DataBean implements Parcelable{
        private int document_id;
        private int display_type;
        private String title;
        private int comment_count;

        private int vote_count;
        private int contribute;
        private int timestamp;

        private String share_url;


        private String url;
        private String source_name;
        private int hit_count;

        private String hit_count_string;
        private long publish_time;
        private String published_at;
        private String thumbnail;

        private int author_id;
        private String author_name;
        private String author_avatar;
        /**
         * id : 683406
         * name : 生活如此多焦
         * avatar : http://ww2.sinaimg.cn/large/005PR129jw1f0nbd4sgj6j305k05kdgc.jpg
         */

        private List<NewsModel.RecommendersBean> recommenders;

        public int getDocument_id() {
            return this.document_id;
        }

        public void setDocument_id(int document_id) {
            this.document_id = document_id;
        }

        public int getDisplay_type() {
            return this.display_type;
        }

        public void setDisplay_type(int display_type) {
            this.display_type = display_type;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getComment_count() {
            return this.comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getVote_count() {
            return this.vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getContribute() {
            return this.contribute;
        }

        public void setContribute(int contribute) {
            this.contribute = contribute;
        }

        public int getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getShare_url() {
            return this.share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSource_name() {
            return this.source_name;
        }

        public void setSource_name(String source_name) {
            this.source_name = source_name;
        }

        public int getHit_count() {
            return this.hit_count;
        }

        public void setHit_count(int hit_count) {
            this.hit_count = hit_count;
        }

        public String getHit_count_string() {
            return this.hit_count_string;
        }

        public void setHit_count_string(String hit_count_string) {
            this.hit_count_string = hit_count_string;
        }

        public long getPublish_time() {
            return this.publish_time;
        }

        public void setPublish_time(long publish_time) {
            this.publish_time = publish_time;
        }

        public String getPublished_at() {
            return this.published_at;
        }

        public void setPublished_at(String published_at) {
            this.published_at = published_at;
        }

        public String getThumbnail() {
            return this.thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public int getAuthor_id() {
            return this.author_id;
        }

        public void setAuthor_id(int author_id) {
            this.author_id = author_id;
        }

        public String getAuthor_name() {
            return this.author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getAuthor_avatar() {
            return this.author_avatar;
        }

        public void setAuthor_avatar(String author_avatar) {
            this.author_avatar = author_avatar;
        }

        public List<NewsModel.RecommendersBean> getRecommenders() {
            return this.recommenders;
        }

        public void setRecommenders(List<NewsModel.RecommendersBean> recommenders) {
            this.recommenders = recommenders;
        }

        protected DataBean(Parcel in) {
            document_id = in.readInt();
            display_type = in.readInt();
            title = in.readString();
            comment_count = in.readInt();
            vote_count = in.readInt();
            contribute = in.readInt();
            timestamp = in.readInt();
            share_url = in.readString();
            url = in.readString();
            source_name = in.readString();
            hit_count = in.readInt();
            hit_count_string = in.readString();
            publish_time = in.readLong();
            published_at = in.readString();
            thumbnail = in.readString();
            author_id = in.readInt();
            author_name = in.readString();
            author_avatar = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(document_id);
            dest.writeInt(display_type);
            dest.writeString(title);
            dest.writeInt(comment_count);
            dest.writeInt(vote_count);
            dest.writeInt(contribute);
            dest.writeInt(timestamp);
            dest.writeString(share_url);
            dest.writeString(url);
            dest.writeString(source_name);
            dest.writeInt(hit_count);
            dest.writeString(hit_count_string);
            dest.writeLong(publish_time);
            dest.writeString(published_at);
            dest.writeString(thumbnail);
            dest.writeInt(author_id);
            dest.writeString(author_name);
            dest.writeString(author_avatar);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<NewsModel.DataBean> CREATOR = new Creator<NewsModel.DataBean>() {
            @Override
            public NewsModel.DataBean createFromParcel(Parcel in) {
                return new NewsModel.DataBean(in);
            }

            @Override
            public NewsModel.DataBean[] newArray(int size) {
                return new NewsModel.DataBean[size];
            }
        };
    }

    public static class RecommendersBean implements Parcelable{
        private int id;
        private String name;
        private String avatar;

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        protected RecommendersBean(Parcel in) {
            id = in.readInt();
            name = in.readString();
            avatar = in.readString();
        }

        public static final Creator<NewsModel.RecommendersBean> CREATOR = new Creator<NewsModel.RecommendersBean>() {
            @Override
            public NewsModel.RecommendersBean createFromParcel(Parcel in) {
                return new NewsModel.RecommendersBean(in);
            }

            @Override
            public NewsModel.RecommendersBean[] newArray(int size) {
                return new NewsModel.RecommendersBean[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(name);
            parcel.writeString(avatar);
        }
    }

}
