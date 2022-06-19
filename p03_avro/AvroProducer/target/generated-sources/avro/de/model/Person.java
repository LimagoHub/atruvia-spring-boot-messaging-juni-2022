/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package de.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Person extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6875195743043199979L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Person\",\"namespace\":\"de.model\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"firstname\",\"type\":\"string\"},{\"name\":\"lastname\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Person> ENCODER =
      new BinaryMessageEncoder<Person>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Person> DECODER =
      new BinaryMessageDecoder<Person>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Person> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Person> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Person> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Person>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Person to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Person from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Person instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Person fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence id;
  private java.lang.CharSequence firstname;
  private java.lang.CharSequence lastname;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Person() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param firstname The new value for firstname
   * @param lastname The new value for lastname
   */
  public Person(java.lang.CharSequence id, java.lang.CharSequence firstname, java.lang.CharSequence lastname) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return firstname;
    case 2: return lastname;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: firstname = (java.lang.CharSequence)value$; break;
    case 2: lastname = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'firstname' field.
   * @return The value of the 'firstname' field.
   */
  public java.lang.CharSequence getFirstname() {
    return firstname;
  }


  /**
   * Sets the value of the 'firstname' field.
   * @param value the value to set.
   */
  public void setFirstname(java.lang.CharSequence value) {
    this.firstname = value;
  }

  /**
   * Gets the value of the 'lastname' field.
   * @return The value of the 'lastname' field.
   */
  public java.lang.CharSequence getLastname() {
    return lastname;
  }


  /**
   * Sets the value of the 'lastname' field.
   * @param value the value to set.
   */
  public void setLastname(java.lang.CharSequence value) {
    this.lastname = value;
  }

  /**
   * Creates a new Person RecordBuilder.
   * @return A new Person RecordBuilder
   */
  public static de.model.Person.Builder newBuilder() {
    return new de.model.Person.Builder();
  }

  /**
   * Creates a new Person RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Person RecordBuilder
   */
  public static de.model.Person.Builder newBuilder(de.model.Person.Builder other) {
    if (other == null) {
      return new de.model.Person.Builder();
    } else {
      return new de.model.Person.Builder(other);
    }
  }

  /**
   * Creates a new Person RecordBuilder by copying an existing Person instance.
   * @param other The existing instance to copy.
   * @return A new Person RecordBuilder
   */
  public static de.model.Person.Builder newBuilder(de.model.Person other) {
    if (other == null) {
      return new de.model.Person.Builder();
    } else {
      return new de.model.Person.Builder(other);
    }
  }

  /**
   * RecordBuilder for Person instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Person>
    implements org.apache.avro.data.RecordBuilder<Person> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence firstname;
    private java.lang.CharSequence lastname;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(de.model.Person.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.firstname)) {
        this.firstname = data().deepCopy(fields()[1].schema(), other.firstname);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.lastname)) {
        this.lastname = data().deepCopy(fields()[2].schema(), other.lastname);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing Person instance
     * @param other The existing instance to copy.
     */
    private Builder(de.model.Person other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.firstname)) {
        this.firstname = data().deepCopy(fields()[1].schema(), other.firstname);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.lastname)) {
        this.lastname = data().deepCopy(fields()[2].schema(), other.lastname);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public de.model.Person.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public de.model.Person.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'firstname' field.
      * @return The value.
      */
    public java.lang.CharSequence getFirstname() {
      return firstname;
    }


    /**
      * Sets the value of the 'firstname' field.
      * @param value The value of 'firstname'.
      * @return This builder.
      */
    public de.model.Person.Builder setFirstname(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.firstname = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'firstname' field has been set.
      * @return True if the 'firstname' field has been set, false otherwise.
      */
    public boolean hasFirstname() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'firstname' field.
      * @return This builder.
      */
    public de.model.Person.Builder clearFirstname() {
      firstname = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'lastname' field.
      * @return The value.
      */
    public java.lang.CharSequence getLastname() {
      return lastname;
    }


    /**
      * Sets the value of the 'lastname' field.
      * @param value The value of 'lastname'.
      * @return This builder.
      */
    public de.model.Person.Builder setLastname(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.lastname = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'lastname' field has been set.
      * @return True if the 'lastname' field has been set, false otherwise.
      */
    public boolean hasLastname() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'lastname' field.
      * @return This builder.
      */
    public de.model.Person.Builder clearLastname() {
      lastname = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Person build() {
      try {
        Person record = new Person();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.firstname = fieldSetFlags()[1] ? this.firstname : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.lastname = fieldSetFlags()[2] ? this.lastname : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Person>
    WRITER$ = (org.apache.avro.io.DatumWriter<Person>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Person>
    READER$ = (org.apache.avro.io.DatumReader<Person>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    out.writeString(this.firstname);

    out.writeString(this.lastname);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);

      this.firstname = in.readString(this.firstname instanceof Utf8 ? (Utf8)this.firstname : null);

      this.lastname = in.readString(this.lastname instanceof Utf8 ? (Utf8)this.lastname : null);

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          break;

        case 1:
          this.firstname = in.readString(this.firstname instanceof Utf8 ? (Utf8)this.firstname : null);
          break;

        case 2:
          this.lastname = in.readString(this.lastname instanceof Utf8 ? (Utf8)this.lastname : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









