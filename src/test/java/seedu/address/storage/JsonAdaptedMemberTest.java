package seedu.address.storage;

import org.junit.jupiter.api.Test;


class JsonAdaptedMemberTest {

    @Test
    void getMemberName() {

    }

    @Test
    void toModelType_invalidType_throwsIllegalJsonValueException() {


    }

    @Test
    void toModelType_invalidWhitespaceName_throwsIllegalJsonValueException() {
        final String memberName = " ";
        JsonAdaptedMember member = new JsonAdaptedMember(memberName);


    }

    @Test
    void toModelType_invalidSlashName_throwsIllegalJsonValueException() {
        final String memberName = "/friend";
        JsonAdaptedMember member = new JsonAdaptedMember(memberName);


    }

    @Test
    void toModelType_nullName_throwsIllegalJsonValueException() {
        final String memberName = null;
        JsonAdaptedMember member = new JsonAdaptedMember(memberName);


    }

    @Test
    void toModelType_validName_returnsMember() {

    }
}